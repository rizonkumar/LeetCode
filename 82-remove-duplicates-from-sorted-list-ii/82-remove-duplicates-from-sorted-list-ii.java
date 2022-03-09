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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                //skip the node whose values are equals to head
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                // skip all duplicates
                prev.next = head.next;  // connect the node
            } else {
                // if the values are not equal
                prev = prev.next;
            }
            // in every case we need to move head
            head = head.next;
        }
        return dummy.next;
    }
}