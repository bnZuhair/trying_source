#!/usr/bin/env node

"use strict";

var util = require("util");
var childProc = require("child_process");


// ************************************

const HTTP_PORT = 8039;
const MAX_CHILDREN = 20;

var delay = util.promisify(setTimeout);


main().catch(console.error);


// ************************************

async function main() {
   console.log(`Load testing http://localhost:${HTTP_PORT}...`);
   while (true) {
      let status = true;
      process.stdout.write(`trying ${MAX_CHILDREN} requests to the server \n`);
      for (let i = 0; i < MAX_CHILDREN; i++) {
         let child = childProc.spawn('node', ['ex6.js']);
         child.on("exit", (code) => {
            if (code != 0) {
               status = false;
            }
         });
      }
      console.log(status ? "seccess" : "faild");

      await delay(500);
   }
}
