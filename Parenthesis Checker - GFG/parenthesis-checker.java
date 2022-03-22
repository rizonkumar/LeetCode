// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        
        if(n %2 != 0) {
            return false;
        }
        
        for(int i=0; i<n; i++) {
            char cur = s.charAt(i);
            
            // Push every opening bracket to stack
            if(cur == '(' || cur == '{' || cur == '[') {
                st.push(cur);
            }
            
            // check for corresponding opening bracket 
            if(cur == ')') {
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
                else
                    return false;
            }
            
            
            if(cur == '}') {
                if(!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                }
                else
                    return false;
            }
            
            if(cur == ']') {
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }
                else
                    return false;
            }
        }
        
        // if stack is empty. it means all the opening brackets 
        // have corresponding closing brackets.
        if(st.isEmpty()) {
            return true;
        }
        else
            return false;
    }
}