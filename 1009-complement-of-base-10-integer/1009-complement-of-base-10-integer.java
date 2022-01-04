class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0){
            return 1;                        
        }
        int no = 0;
        int power = 0;
        
        while(no < n)
        {
            no += Math.pow(2, power);
            power++;
        }
        
        return no - n;
    }
}