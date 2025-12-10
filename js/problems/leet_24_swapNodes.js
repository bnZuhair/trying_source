/**
 * result: faild
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function (head) {
  if (head === null || head === undefined) {
    return head;
  }
  let currentN = head;
  while (currentN && currentN.next) {
    const previousN = currentN;
    currentN = currentN.next;
    const nextN = currentN.next;

    previousN.next = currentN.next;
    currentN.next = previousN;

    currentN = nextN;
  }
  return head;
};
