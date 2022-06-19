// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};


 // } Driver Code Ends
//User function Template for C++

/*Link list node 
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};*/

class Solution
{
    public:
    Node* reverseBetween(Node* head, int m, int n)
    {
        //code here
        if (!head)
            return NULL;

        //inserting dummy head
        Node *dummyhead = new Node(-1);
        dummyhead->next = head;
        head = dummyhead;

        // inserting dummy tail
        Node *dummyTail = new Node(-1);
        Node *itr = head;
        while (itr->next != NULL)
            itr = itr->next;
        itr->next = dummyTail;

        // reaching the first node from where we have to reverse     
        int go = m;
        Node *prev = NULL, *curr = head;
        while (go--)
        {
            prev = curr;
            curr = curr->next;
        }

        // reaching the end node till where we have to reverse
        int cnt = n - m;
        Node *ptr = curr, *start = prev;
        while (cnt-- && ptr)
            ptr = ptr->next;

        // saving pointers
        Node *p1, *p2, *p3, *p4;
        p1 = prev, p2 = curr, p3 = ptr, p4 = ptr->next;

        // reversing link between m to n        
        cnt = n - m;
        prev = prev->next;
        curr = curr->next;
        Node *nxt;
        while (cnt--)
        {
            nxt = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nxt;
        }

        // merging back final linked list
        p1->next = p3;
        p2->next = p4;

        // removing dummy head
        head = head->next;

        // removing dummy tail
        itr = head;
        while (itr->next->next != NULL)
            itr = itr->next;
        itr->next = NULL;

        // return final head
        return head;
    }
};

// { Driver Code Starts.

/* Function to print linked list */
void printList(struct Node *head)
{
	struct Node *temp = head;
	while (temp != NULL)
	{
		printf("%d ", temp->data);
		temp = temp->next;
	}
}



// Driver program to test above functions
int main()
{
	int T;
	cin >> T;

	while (T--)
	{
		int N, m, n;
		cin >> N>>m>>n;

		Node *head = NULL;
		Node *temp = head;

		for (int i = 0; i < N; i++) {
			int data;
			cin >> data;
			if (head == NULL)
				head = temp = new Node(data);
			else
			{
				temp->next = new Node(data);
				temp = temp->next;
			}
		}

		

        Solution ob;

		Node* newhead = ob.reverseBetween(head, m, n);
		printList(newhead);

		cout << "\n";



	}
	return 0;
}
  // } Driver Code Ends