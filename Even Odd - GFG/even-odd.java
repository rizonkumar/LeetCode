// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            Solution obj = new Solution();
            obj.evenOdd(a, b);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public void evenOdd(int a, int b){
        int rem = a % 2;
        if(rem == 0){
   //         cout<<a<<"\n"<<b<<endl;
            System.out.println(a);
            System.out.println(b);
        } else {
  //          cout<<b<<"\n"<<a<<endl;
            System.out.println(b);
            System.out.println(a);
        }
    }
}