/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function (salary) {
  let min = Number.POSITIVE_INFINITY,
    max = Number.NEGATIVE_INFINITY;

  for (const sal of salary) {
    if (sal < min) {
      min = sal;
    }
    if (sal > max) {
      max = sal;
    }
  }

  let total = 0;
  for (const sal of salary) if (sal < max && sal > min) total += sal;

  return total / (salary.length - 2);
};
