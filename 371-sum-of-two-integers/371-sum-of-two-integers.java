class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            // creating temp because in 'and' operation we need original value of 'a' NOT the Xor value of 'a'. so we use temp in b.
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;   
    }
}