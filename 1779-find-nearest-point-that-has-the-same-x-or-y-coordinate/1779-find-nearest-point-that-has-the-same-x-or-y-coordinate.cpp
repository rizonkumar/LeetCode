/*

We can simply iterate over all the points in points array and if a point is valid (has the same x or y co-ordinate as our location), find its manhattan distance and remember its index if that is the minimum one. Lastly, just return the index.

Time Complexity : O(N), where N is the numbe of points in the points vector.
Space Complexity : O(1), since only constant space is used.

*/
class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        int n = points.size(), mn = INT_MAX, ans = -1, manhattan;
        for(int i = 0; i < n; i++)
            if(points[i][0] == x || points[i][1] == y){
                manhattan = abs(x - points[i][0]) + abs(y - points[i][1]);
                if(manhattan < mn)
                    mn = manhattan, ans = i;            
            }
        return ans;
    }
};