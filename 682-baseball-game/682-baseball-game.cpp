class Solution {
public:
    int calPoints(vector<string>& ops) {
        vector<int> score;
        
        for(auto &it: ops){
            if(it == "D"){
                score.push_back(score.back() * 2);
            }
            else if(it == "C"){
                score.pop_back();
            }
            else if(it == "+"){
                // we need last two element so we find size
                int size = score.size();
                score.push_back(score[size - 1] + score[size - 2]); 
            }
            else {
                // convert string to integer
                score.push_back(stoi(it));
            }
        }
        int sum = 0;
        for(auto &it: score){
            sum += it;
        }
        
        return sum;
    }
};