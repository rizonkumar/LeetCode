class Solution {
    public int countPrimes(int n) {
        
        boolean[] primes = new boolean[n+1]; //array start from 0
        
        if(n==0 || n == 1) return 0;
        
        // false in array here means number is prime
        int count = 0;
        for(int i = 2; i*i <=n; i++){
            if(!primes[i]){
                for(int j=i*i;j<=n;j+=i){
                    primes[j] = true;
                }
            }
        }
        
        for(int i = 2; i<n; i++){
            if(!primes[i]){
                count++;
            }
        }
        return count;
    }
}