/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodesList = new ArrayList<>();
        ListNode nowNode = head;
        while (nowNode != null) {
            nodesList.add(nowNode);
            nowNode = nowNode.next;
        }

        if (nodesList.size() == n) {
            return head.next;
        }

        nodesList.get(nodesList.size() - n - 1).next =
                nodesList.get(nodesList.size() - n).next;

        return head;
    }
}