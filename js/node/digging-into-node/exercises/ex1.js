#!/usr/bin/env node

"strictmode";

const getStdin = require("get-stdin");
const path = require('path');
const fs = require('fs');
const utils = require('util');

args = require('minimist')(process.argv.slice(2),
   {
      boolean: ["help", "in"],
      string: ['file']
   }
);

const BaseDir = path.resolve(__dirname);

if (args.help) {
   printHelp();
} else if (args.file) {
   const inputFile = fs.readFileSync(path.join(BaseDir, args.file));
   const output = inputFile.toString().toUpperCase();
   process.stdout.write(output);

} else if (args.in) {
   getStdin()
      .then((content) => {
         process.stdout.write(content.toUpperCase());
      })

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

// this is not updagted
function printHelp() {
   console.log('ex1 usage:\n');
   console.log('  ex1.js --help --content={string}')
   console.log('--help                          print this help')
   console.log('--content={string}              the content to be printed')
   console.log('--in                            send input stream instade of a file')
   console.log('');
}
