/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nowval = (l1.val + l2.val) % 10;
        int nextval = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode res = new ListNode(nowval);
        ListNode nowNode = res;
        while (l1 != null || l2 != null || nextval != 0) {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

            nowval = (l1Val + l2Val + nextval) % 10;
            nextval = (l1Val + l2Val + nextval) / 10;
            ListNode newNode = new ListNode(nowval);
            nowNode.next = newNode;
            nowNode = newNode;
        }
        return res;
    }
}