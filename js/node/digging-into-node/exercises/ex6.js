#!/usr/bin/env node
"use strict";

var util = require("util");
var path = require("path");
var http = require("http");

var express = require("express");
var sqlite3 = require("sqlite3");

const app = express();

// ************************************

const DB_PATH = path.join(__dirname, "my.db");
const WEB_PATH = path.join(__dirname, "web");
const HTTP_PORT = 8039;

var delay = util.promisify(setTimeout);

// define some SQLite3 database helpers
//   (comment out if sqlite3 not working for you)
var myDB = new sqlite3.Database(DB_PATH);
var SQL3 = {
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

var httpserv = http.createServer(app);


main();


// ************************************

function main() {
   defineRoutes();

   httpserv.listen(HTTP_PORT);
   console.log(`Listening on http://localhost:${HTTP_PORT}...`);
}
function defineRoutes() {
   app.get("/get-records", async function (req, res) {
      const result = await getAllRecords();
      res.writeHead(200, {
         "Content-Type": 'application/json',
         "Cashe-Control": "no-cache"
      });
      res.end(JSON.stringify(result));
   })
   app.use(function rewriter(req, res, next) {
      if (/^\/(?:index\/?)?(?:[?#].*$)?$/.test(req.url)) {
         req.url = "/index.html";
      }
      else if (/^\/js\/.+$/.test(req.url)) {
         next();
         return;
      }
      else if (/^\/(?:[\w\d]+)(?:[\/?#].*$)?$/.test(req.url)) {
         let [, basename] = req.url.match(/^\/([\w\d]+)(?:[\/?#].*$)?$/);
         req.url = `${basename}.html`;
      }

      next();
   });
   // static files server
   app.use(express.static(WEB_PATH, { maxAge: 100, }));
}

// *************************
// NOTE: if sqlite3 is not working for you,
//   comment this version out
// *************************
async function getAllRecords() {
   var result = await SQL3.all(
      `
		SELECT
			Something.data AS "something",
			Other.data AS "other"
		FROM
			Something
			JOIN Other ON (Something.otherID = Other.id)
		ORDER BY
			Other.id DESC, Something.data
		`
   );

   return result;
}
