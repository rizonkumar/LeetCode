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
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long factorial(int n) {
    long fact = 1;
    for (int i = 2; i <= n; i++) {
        fact = fact * i;
    }
    return fact;
}
    public long findRank(String S)
    {
        int n = S.length(), count ;
        long ans = 0;
        for(int i=0; i<n; i++)
        {
            count = 0;
            for(int j=i+1; j<n; j++)
            {
                if((int)S.charAt(i)>(int)S.charAt(j))
                {
                    count++;
                }
            }
            ans += factorial(n-i-1)*count;
        }
        return ans+1;
    }
}