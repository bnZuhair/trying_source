#!/usr/bin/env node

"use strict";

var util = require("util");
var path = require("path");
var fs = require("fs");

var sqlite3 = require("sqlite3");
// require("console.table");


// ************************************

const DB_PATH = path.join(__dirname, "my.db");
const DB_SQL_PATH = path.join(__dirname, "mydb.sql");

var args = require("minimist")(process.argv.slice(2), {
   string: ["other",],
});

main().catch(console.error);


// ************************************

var SQL3;

async function main() {
   if (!args.other) {
      error("Missing '--other=..'");
      return;
   }

   // define some SQLite3 database helpers
   var myDB = new sqlite3.Database(DB_PATH);
   SQL3 = {
      run(...args) {
         return new Promise(function c(resolve, reject) {
            myDB.run(...args, function onResult(err) {
               if (err) reject(err);
               else resolve(this);
            });
         });
      },
      get: util.promisify(myDB.get.bind(myDB)),
      all: util.promisify(myDB.all.bind(myDB)),
      exec: util.promisify(myDB.exec.bind(myDB)),
   };

   var initSQL = fs.readFileSync(DB_SQL_PATH, "utf-8");
   await SQL3.exec(initSQL);


   var other = args.other;
   var something = Math.trunc(Math.random() * 1E9);

   // ***********

   const otherId = await insertOrlookUp(other);
   if (otherId) {
      let result = await insertSomething(otherId, something);
      if (result) {
         console.log("everything is working so u inserted row here is the table:\n");
         const records = await getAllRecords();
         if (records && records.length > 0) {
            console.table(records);
         }
         return;
      }
   }
   error("Oops!");
}
async function insertOrlookUp(other) {
   const result = await SQL3.get(
      `SELECT  id
       FROM Other
       WHERE data = ?
       `,
      other
   )
   if (result && result.id) {
      return result.id
   } else {
      const result = await SQL3.run(
         `INSERT INTO Other (data)
          VALUES (?)
         `,
         other
      );
      if (result && result.lastID) {
         return result.lastID;
      }
   }
}
async function insertSomething(otherId, something) {
   const result = await SQL3.run(
      `INSERT INTO Something(otherID, data)
       VALUES (?, ?)
      `,
      otherId,
      something
   );
   if (result && result.changes > 0) {
      return true;
   }
   return false;
}
async function getAllRecords() {
   const results = await SQL3.all(
      `
      SELECT Other.data as other, Something.data as something
      FROM Something JOIN Other 
         ON (Something.otherID = Other.id)
      ORDER BY Something.id
      `
   )
   if (results && results.length > 0) {
      return results;
   }
}

function error(err) {
   if (err) {
      console.error(err.toString());
      console.log("");
   }
}
