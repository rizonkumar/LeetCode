class Solution {
    public String minRemoveToMakeValid(String s) {
        
        // string to array
        char chars[] = s.toCharArray();
        
        // Stack of integer for index
        Stack<Integer>  st = new Stack<>();
        for(int i=0; i<chars.length;i++){
            // when its opening bracket push them to stack as index
            if(chars[i] == '(') {
                st.push(i);
            }
            // when closing bracket pop them
            else if (chars[i] == ')'){
               // when starting bracket is )  its invalid 
                if(st.size() == 0){
                    chars[i] = '.'; // mark as dot;
                } else {
                   st.pop(); // if pair availabe pop it
                }
            }
        }
        // remaining in stack is also invalid
        while(st.size() > 0){
            chars[st.pop()] = '.';  // mark them dot
        }
        
        // apart from . add other to string builder as . is invalid
        StringBuilder ans = new StringBuilder();
        for(char c: chars){
            if(c != '.'){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}