class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } else {
                st.pop();
                if(st.empty()){
                    st.push(i);
                } else {
                    int len = i - st.peek();    // calculate the len
                    max = Math.max(max, len);   // take the max out of it
                }
            }
        }
        return max;
    }
}