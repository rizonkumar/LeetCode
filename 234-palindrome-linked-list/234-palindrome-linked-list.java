class Solution {
    // reverse code
    public ListNode reverseList(ListNode head) {
        
        // edge case
        if(head == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
    return prev;
    }
    
    // middle of the linked list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;
        
        //compare both the half
        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);
        
        if(head == null || headSecond == null)
            return true;
        return false;
    }
}