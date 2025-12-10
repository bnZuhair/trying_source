/**
 * @param {string} s
 * @return {number}
 */
var balancedString = function (s) {
  const freq = { q: 0, w: 0, r: 0, e: 0 };

  for (const ch of s) {
    freq[ch]++;
  }

  const equaltyNumber = s.length / 4;

  const changable = { q: 0, w: 0, r: 0, e: 0 };
  const needToSub = -1,
    needToAdd = 1,
    noChange = 0;

  for (const letter of s) {
    if (freq[letter] > equaltyNumber) changable[letter] = needToSub;
    else if (freq[letter] < equaltyNumber) changable[letter] = needToAdd;
    else changable[letter] = noChange;
  }

  const neededOperations = equalizeOperations(Object.values(freq));

  let counter = 0;
  for (const letter of s) {
    if (changable[letter] === needToSub && neededOperations) {
      neededOperations = neededOperations - 1;
    }
    counter = counter + 1;
  }

  return counter;
};
function equalizeOperations(freqs) {
  const n = freqs.length;
  const total = freqs.reduce((a, b) => a + b, 0);
  const target = total / n;

  const sumDiff = freqs.reduce((sum, f) => sum + Math.abs(f - target), 0);
  const operations = sumDiff / 2;

  return operations;
}
