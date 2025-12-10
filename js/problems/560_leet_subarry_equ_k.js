/**
 * failed
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function (nums, k) {
  let counter = 0;
  for (let firstPointer = 0; firstPointer < nums.length; firstPointer++) {
    let sum = nums[firstPointer];
    for (
      let secondPointer = firstPointer;
      secondPointer < nums.length;
      secondPointer++
    ) {
      if (secondPointer !== firstPointer) sum += nums[secondPointer];
      if (sum === k) {
        counter++;
      }
    }
  }
  return counter;
};
