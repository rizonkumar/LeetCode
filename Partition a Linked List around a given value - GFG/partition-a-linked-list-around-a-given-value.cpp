// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node* partition(struct Node* head, int x);

struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

/* Function to print linked list */
void printList(struct Node* node) {
    while (node != NULL) {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}

/* Drier program to test above function*/
int main(void) {
    int t;
    cin >> t;

    while (t--) {
        struct Node* head = NULL;
        struct Node* temp = NULL;
        int n;
        cin >> n;

        for (int i = 0; i < n; i++) {
            int value;
            cin >> value;
            if (i == 0) {
                head = new Node(value);
                temp = head;
            } else {
                temp->next = new Node(value);
                temp = temp->next;
            }
        }

        int k;
        cin >> k;

        // Solution ob;

        head = partition(head, k);
        printList(head);
    }

    return (0);
}
// } Driver Code Ends


// User function Template for C++

/*struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};*/

struct Node* partition(struct Node* head, int x) {
    struct Node*dummyless=new Node(-1);
    struct Node*dummymore=new Node(-1);
    struct Node*dummyequal=new Node(-1);
    Node*cur1=dummyless,*cur2=dummyequal,*cur3=dummymore;
    
    while(head){
        if(head->data<x)
        {
            struct Node*cur=new Node(head->data);
            cur1->next=cur;
            cur1=cur1->next;
            
        }
        else if(head->data>x)
        {
            struct Node*cur=new Node(head->data);
            cur3->next=cur;
            cur3=cur3->next;
            
        }
        else
         {
            struct Node*cur=new Node(head->data);
            cur2->next=cur;
            cur2=cur2->next;
         }
         head=head->next;
      }
    
     if(dummyequal->next)
        {
            cur1->next=dummyequal->next;
            cur2->next=dummymore->next;
            
            return dummyless->next;
        }
        else
        {
            cur1->next=dummymore->next;
            
            return dummyless->next;
        }
        
        return NULL;
}