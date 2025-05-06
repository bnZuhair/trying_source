#!/usr/bin/env node

"strictmode";

const getStdin = require("get-stdin");
const path = require('path');
const fs = require('fs');

args = require('minimist')(process.argv.slice(2),
   {
      boolean: ["help", "in"],
      string: ['file']
   }
);

const BASE_DIR = path.resolve(process.env.BASE_DIR || __dirname);

if (args.help) {
   printHelp();
} else if (args.file) {
   fs.readFile(path.join(BASE_DIR, args.file), (err, content) => {
      if (err) {
         error(err);
      } else {
         const output = content.toString().toUpperCase();
         process.stdout.write(output);
      }
   });
} else if (args.in || args._.includes("-")) {
   getStdin()
      .then((content) => {
         const output = content.toString().toUpperCase();
         process.stdout.write(output);
      }).catch(error);
} else {
   error("incorrect usage!\n", true);
}
// ***************
function error(msg, printHelp = false) {
   console.log(msg + "\n");
   if (printHelp) {
      printHelp()
   }
}

function printHelp() {
   console.log('ex1 usage:\n');
   console.log('  ex1.js --help')
   console.log('--help                          print this help')
   console.log('--file={filePath}               the content to be printed')
   console.log('--in, -                         send input stream instade of a file')
   console.log('');
}
