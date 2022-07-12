// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] col=new int[n];
        Arrays.fill(col,-1);
        
        return isMColorPossible(graph,0,col,m,n);
    }
    
    private boolean isMColorPossible(boolean graph[][],int cur,int[] col,int m,int n){
        if(cur==n){
            return true;
        }
        
        for(int i=1;i<=m;i++){
            if(!isColorValid(graph,cur,i,col)){
                continue;
            }
            
            col[cur]=i;
            
            if(isMColorPossible(graph,cur+1,col,m,n)){
                return true;
            }
            
            col[cur]=-1;
        }
        
        return false;
    }
    
    private boolean isColorValid(boolean graph[][],int cur,int color,int[] col){
        int n=graph.length;
        
        for(int i=0;i<n;i++){
            if(!graph[cur][i]){
                continue;
            }
            
            if(color==col[i]){
                return false;
            }
        }
        
        return true;
    }
}
