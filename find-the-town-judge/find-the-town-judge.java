class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trust_count = new int[N];
        for(int[] t : trust){
            trust_count[t[0]-1]--;
            trust_count[t[1]-1]++;
        }
        int result = -1;
        for(int i = 0;i < N;++i){
            if(trust_count[i] == N-1) 
                // because number are from 1 to n so i + 1
                return i + 1;
        }
        return result;
    }
}