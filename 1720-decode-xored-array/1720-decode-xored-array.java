class Solution {
    
    /*
        encoded[i] = arr[i] XOR arr[i + 1] ----- (1)
        
        to get arr[i + 1], xor both the sides with arr[i] in equation (1)
        
        encoded[i] ^ arr[i] = arr[i] ^ arr[i + 1] ^ arr[i]
        
        encoded[i] ^ arr[i] = arr[i] ^ arr[i] ^ arr[i + 1] 
        
        [As we know : a ^ b = b ^ a]
        
        encoded[i] ^ arr[i] = 0 ^ arr[i + 1]
        
        [As we know : a ^ a = 0 & a ^ 0 = a]
        
        encoded[i] ^ arr[i] = arr[i + 1]
        
        Since arr[i] as a first element given to us so therefore we
        can get arr[i + 1].
        
        In the next step, arr[i + 1] will becomes arr[i](first).
        
        Once we've arr[i + 1] we can find arr[i + 2] by using the above
        process.
        
        Similarly, we can find all the elements of hidden array arr.
    */
    
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] arr = new int[length + 1];
        arr[0] = first;
        for(int i = 0; i < length; i += 1) {
            arr[i + 1] = encoded[i] ^ arr[i];
        }
        return arr;
    }
}