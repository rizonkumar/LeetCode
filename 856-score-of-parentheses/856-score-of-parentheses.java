class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        // ( -> treat as -1
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == '('){
                st.push(-1);    // push if its (
            } else {
                // two case
                if(st.peek() == -1){    //() => 1
                    st.pop();
                    st.push(1);
                } else {    //(A B) => A + B or (A) we need to add the val
                    int val = 0;
                    while(st.peek() != -1){
                        val += st.pop();
                    }
                    st.pop();
                    st.push(2*val);
                }
            }
        }
        
        // () () => 2
        int val = 0;
        while(st.size() > 0)
        {
            val += st.pop();
        }
        return val;
    }
}