// Stack Solution

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
        
        for(int i=0; i<p.length; i++){
            // two condition now pop and pushing
            //popping
            //whenever two dots present we pop it and stack should't be emptp
            if(!s.isEmpty() && p[i].equals("..")) 
                s.pop();
            
            //pushing
            //whenever empty string and when there is not single dot or double dot
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        // base case
        if(s.isEmpty()) return "/";
        //if not empty iterate over the stack and append the element in string builder in res.
        while(!s.isEmpty()){
            // appending in front rather than back because stack would pop the last element first but we need in FIFO order.
            res.insert(0, s.pop()). insert(0, "/");
        }
        return res.toString();
    }
}