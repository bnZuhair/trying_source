/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function (operations) {
   return operations.reduce((result, operation) => {
      return operation.includes("+") ? result + 1 : result - 1;
   }, 0);
};

var finalValueAfterOperations = function (operations) {
   let x = 0;
   operations.forEach((op) => {
      op.includes("+") ? ++x : --x;
   });
   return x;
};
