// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
   
   static Node reverse(Node node)
   {
      Node prev = null;
      Node current = node;
      Node next = null;
      while (current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      node = prev;
      return node;
   }
  
  static Node addTwoLists(Node first, Node second){
      // code here
      // return head of sum list
      
      Node ans=new Node(0);
      Node curr=ans;
      
      Node l1=reverse(first);
      Node l2=reverse(second);
      
      int carry=0;
      
      while(l1!=null || l2!=null || carry == 1){
          
          int x=(l1!=null)?l1.data:0;
          int y=(l2!=null)?l2.data:0;
          
          int sum=carry+x+y;
          
          carry=sum/10;
          
          curr.next=new Node(sum%10);
          
          if(l1!=null) l1=l1.next;
              
          if(l2!=null) l2=l2.next;
              
          curr=curr.next;
      }
      
      return reverse(ans.next);
  }
}