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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode high = new ListNode(0);
        
        ListNode smallHead = small;
        ListNode highHead = high;
        
        while(head!=null){
            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if(head.val < x){
                // small list
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list
                // high list
                highHead.next = head;
                highHead = highHead.next;
            }
            // move ahead in the original list
            head = head.next;
        }
        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        // connect the both list
        highHead.next = null;
        smallHead.next = high.next;
        
        return small.next;
    }
    
}