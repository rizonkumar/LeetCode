class KthLargest {
    // min heap priority queue
    priority_queue<int, vector<int>, greater<int>> pq;
    int maxi;
public:
    KthLargest(int k, vector<int>& nums) {
        maxi = k;
        for(auto it: nums){
            pq.push(it);
        }
    }
    
    int add(int val) {
        pq.push(val);
        while(pq.size() != maxi){
            pq.pop();
        }
        return pq.top();
    }
};
