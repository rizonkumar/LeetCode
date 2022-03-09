public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0, diff = 0;
        ListNode head1 = headA;
        ListNode head2 = headB;
        
        while(head1 != null){
            l1++;
            head1 = head1.next;
        }
        while(head2 != null){
            l2++;
            head2 = head2.next;
        }
        
        if(l1 < l2){
            head1 = headB;
            head2 = headA;
            diff = l2 - l1;
        } else {
            head1 = headA;
            head2 = headB;
            diff = l1 - l2;
        }
        
        for(int i = 0; i < diff; i++)
            head1 = head1.next; 
        while(head1 != null && head2 != null){
            if(head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}