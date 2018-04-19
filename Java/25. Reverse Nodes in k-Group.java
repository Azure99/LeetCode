/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nowNode = head;

        while (canReverse(nowNode, k)) {
            ListNode[] listArr = new ListNode[k];
            int[] valArr = new int[k];
            for (int i = 0; i < k; i++) {
                listArr[i] = nowNode;
                valArr[i] = nowNode.val;
                nowNode = nowNode.next;
            }

            for (int i = k - 1; i >= 0; i--) {
                listArr[k - i - 1].val = valArr[i];
            }
        }

        return head;
    }

    private boolean canReverse(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return false;
            } else {
                head = head.next;
            }
        }
        return true;
    }
}