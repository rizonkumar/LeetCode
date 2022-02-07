class Solution {
    public char findTheDifference(String s, String t) {
        
        int a = s.length();
        int b = t.length();
        
        if(a == 0){
            return t.charAt(0);
        } else {
            char[] l = s.toCharArray();
            char[] h = t.toCharArray();
            
            Arrays.sort(l);
            Arrays.sort(h);
            
            for(int i = 0; i < a; i++){
                if(l[i] != h[i]){
                    return h[i];
                }
            }
            return h[b - 1];
        }  
    }
}