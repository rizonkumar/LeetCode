/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue(comparator);
        for(ListNode linkedList : lists){
            ListNode cur = linkedList;
            while(cur != null){
                ListNode temp = cur.next;
                cur.next = null;
                heap.add(cur);
                cur = temp;
            }
        }
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while(heap.size() > 0){
            cur.next = heap.poll();
            cur = cur.next;
        }
        return sentinel.next;
    }
}