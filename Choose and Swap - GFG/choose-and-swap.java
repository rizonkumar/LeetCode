// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    
    String chooseandswap(String ae){
        
        char [] ch = ae.toCharArray();
        int n = ae.length();
        String res = "";
        int i;
        TreeSet<Character> hs = new TreeSet<>();
        
        for(i=0;i<n;i++)
            hs.add(ch[i]);
        
        Iterator<Character> in = hs.iterator();
        char tem = in.next();
        char a='1';
        char b='1';
        for(i=0;i<n;i++){
            if(i!=0 && ch[i]>tem)
                tem = in.next();
                
            if(ch[i]>tem && a=='1'){
                a = ch[i];
                b = tem;
                res+=b;
            }
            else if(a!='1' && ch[i]==a)
                res+=b;
            else if(a!='1' && ch[i]==b)
                res+=a;
            else
                res+=ch[i];
            
            
        }
        
        return res;
    }
    
}