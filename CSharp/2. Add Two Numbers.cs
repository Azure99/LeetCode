/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        int nowValue = (l1.val + l2.val) % 10;
        int nextValue = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode res = new ListNode(nowValue);
        ListNode nowNode = res;
        while (l1 != null || l2 != null || nextValue != 0)
        {
            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            nowValue = (l1Val + l2Val + nextValue) % 10;
            nextValue = (l1Val + l2Val + nextValue) / 10;

            ListNode newNode = new ListNode(nowValue);
            nowNode.next = newNode;
            nowNode = newNode;
        }

        return res;
    }
}