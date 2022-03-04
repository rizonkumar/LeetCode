class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //double 2D array
        double[][] quantity = new double[101][101];
        quantity[0][0] = poured;    // pull in the given quantity at the zeroth level which is 0th glass,0th row.
        
        for(int i = 0; i < query_row; i++){
            for(int j = 0; j <= query_glass; j++){
                double remaining = Math.max(quantity[i][j] - 1, 0); // subtract with max with - 1
                // separate it with left child and right child
                quantity[i+1][j] += remaining / 2.0;    // left child
                quantity[i+1][j+1] += remaining / 2.0;  //right child
            }
        }
        return Math.min(quantity[query_row][query_glass], 1.0);
    }
}