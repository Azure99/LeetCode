/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                que.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        
        if(que.isEmpty()) {
            return null;
        }
        
        ListNode resList = new ListNode(que.peek());
        que.remove();

        ListNode nowNode = resList;
        while (!que.isEmpty()) {
            ListNode newNode = new ListNode(que.peek());
            que.remove();
            nowNode.next = newNode;
            nowNode = newNode;
        }

        return resList;
    }
}