/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function (candies, extraCandies) {
   max = Math.max(...candies);
   return candies.reduce((result, kidCandies) => {
      if ((kidCandies + extraCandies) >= max) {
         return [...result, true];
      } else {
         return [...result, false];
      }
   }, []);
};
