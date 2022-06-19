/*

n = 234

using while loop - 

n % 10 => 234 % 10 = 4
n /= 10 => 234 /= 10 = 23

n = 23

n % 10 => 23 % 10 = 3
n /= 10 => 23 /= 10 = 2

n = 2

n % 10 => 2 % 10 = 2
n /= 10 => 2 / 10 = 0

*/



class Solution {
public:
    int subtractProductAndSum(int n) {
        
        int sum = 0;
        int product = 1;
        int result;
        
        while(n>0){
            int digit = n % 10;
            sum += digit;
            product*= digit;
            n /= 10;
        }
        result = product - sum;
        return result;
    }
};