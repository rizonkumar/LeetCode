// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k)  {
       
       Arrays.sort(arr);
       int ans=arr[n-1]-arr[0];
       int start=arr[0]+k;
       int end=arr[n-1]-k;
     
       for(int i=0;i<n-1;i++)
       { 
            if(arr[i+1]>=k)
           {
               int x=Math.max(arr[i]+k,end);
               int y=Math.min(arr[i+1]-k,start);
               if(x-y < ans)
                   ans=x-y;
           }
       }
       
       return ans;
      
   }
}
