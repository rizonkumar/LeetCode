// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String ip) {
        // Write your code here
        String arr[];
        
        if(ip.contains("."))
            arr=ip.split("\\.");
        else
            arr=ip.split("\\:");
        
        if(arr.length==4)
        {
            if(ip.charAt(ip.length()-1)=='.')
                   return false;
            
            
            for(int i=0;i<arr.length;i++)
            {
                String curr=arr[i];
                
                if(curr.length()==0)
                    return false;
                    
                    if(curr.length()==1&&curr.charAt(0)=='0')
                    continue;
                
                
                if(curr.charAt(0)=='0')
                    return false;
                
                
                try
                {
                    int val=Integer.parseInt(curr);
                    
                    if(val>255)
                    {
                        return false;
                    }
                    
                }
                catch(Exception e)
                {
                    return false;   
                }
                
            }
            return true;
            
            
        }  //ipv4 close;
        else if(arr.length==8)
        {
            
            if(ip.charAt(ip.length()-1)==':')
                   return false;
            
           for(int i=0;i<8;i++)
           {
               
               String curr=arr[i].toLowerCase();
               
               if(curr.length()>4||curr.length()==0)
                   return false;
               
               
               for(int j=0;j<curr.length();j++)
               {
                   char c=curr.charAt(j);
                   
                   if(Character.isDigit(c))
                       continue;
                   
                   if(c>'f')
                       return false;
               }
               
           }
            return true;
            
        }
        
        return false;
        
    }
}