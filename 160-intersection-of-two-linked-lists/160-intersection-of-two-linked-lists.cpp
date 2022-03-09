
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // boundary check
        if(headA == NULL && headB == NULL) return NULL;
        
        ListNode *a = headA;
        ListNode *b = headB;
        
        // if a & b have different length, then we will stop the loop after second iteration.
        while(a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == NULL ? headB : a->next;    // if a is null then shit it to other linked list
                                                // if it not null simply move it to next node
            b = b == NULL ? headA : b->next;    // same for b
        }
        return a;   // the moment a == b we return it.
     }
};