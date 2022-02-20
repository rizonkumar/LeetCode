class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        if(len<=1) return len;
        //ascending order for start, descending order for last
        Arrays.sort(intervals, (a,b)->a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1]);
        int i = 0;
        int cnt = 0;
        for(int j=1; j<len; j++){
            if(intervals[i][0]<=intervals[j][0] && intervals[j][1]<=intervals[i][1])
                cnt++;
            else
                i=j;
        }
        return len-cnt;
    }
}