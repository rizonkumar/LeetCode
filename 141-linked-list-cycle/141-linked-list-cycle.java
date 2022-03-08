/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            // move fast two x fast
            fast = fast.next.next;
            // move slow one x fast
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        
        return false;
    }
}