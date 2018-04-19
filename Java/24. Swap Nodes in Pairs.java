/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode nowNode = head;
        while (nowNode != null && nowNode.next != null) {
            int tmp = nowNode.val;
            nowNode.val = nowNode.next.val;
            nowNode.next.val = tmp;
            nowNode = nowNode.next.next;
        }

        return head;
    }
}