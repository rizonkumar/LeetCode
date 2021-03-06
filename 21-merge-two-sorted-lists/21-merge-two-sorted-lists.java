class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        ListNode dummyHead = new ListNode();
        ListNode ans = dummyHead;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                ans.next = l1;
                l1 = l1.next;
            }
            
            else {
                
                ans.next = l2;
                l2 = l2.next;
            }
            
            ans = ans.next;
        }
        //adding the remaning one
        ans.next = (l1 == null ? l2:l1);
        return dummyHead.next;
    }
}
