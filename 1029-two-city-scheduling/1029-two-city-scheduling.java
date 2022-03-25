class Solution {
    public int twoCitySchedCost(int[][] costs) {
// sort them in basic of loss of city a and city b
//a[0], a[1] -- price for city A, and B for first candidate 
//b[0], b[1] -- price for city A and B for 2nd candidate
//a[0] - a[1] = cost saving on sending first candidate to city A instead of B
//b[0] - b[1] = cost saving on sending 2nd candidate to city A instead of city B
        Arrays.sort(costs, (a,b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        int total = 0;
        for(int i = 0; i < costs.length; i++){
            if(i < costs.length / 2){
                // select city A
                total += costs[i][0];
            } else {
                // select city B
                total += costs[i][1];
            }
        }
        return total;
    }
}