// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    Node sMerge(Node a, Node b){
        Node result = null;
        if(a==null) return (b);
        else if(b==null) return (a);
        if(a.data <= b.data){
            result = a;
            result.next = sMerge(a.next,b);
        } else {
            result = b;
            result.next = sMerge(a,b.next);
        }
        return result;
    }
    Node mergeKList(Node[]arr,int K)
    {
        int i = 0;
        int last = K - 1;
        int j;
        while(last != 0){
            i = 0;
            j = last;
            while(i<j){
                arr[i] = sMerge(arr[i],arr[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        return arr[0];
    }
}
