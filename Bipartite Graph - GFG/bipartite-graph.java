// { Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    
    public boolean helper(int node, ArrayList<ArrayList<Integer>>adj, int[] colors) {
         
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 0;
        
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            for (Integer neighbor : adj.get(curr)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[curr];
                    queue.offer(neighbor);
                    
                } else if (colors[curr] == colors[neighbor]) {
                    return false;
                }
                
            }
        }
        
        return true;
        
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
       
        for (int i=0; i < V; i++) {
            if (colors[i] == -1) {
                if (!helper(i, adj, colors)) {
                    return false;
                }
            }
        }
       
        return true;
    }
}