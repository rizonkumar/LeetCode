// Deque Solution

class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
        
        for(int i=0; i<p.length; i++){
            // two condition now pop and pushing
            //polling
            //whenever two dots present we pop it and queue should't be empty
            if(!s.isEmpty() && p[i].equals("..")) 
                s.poll();
            
            //pushing
            //whenever empty string and when there is not single dot or double dot
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        // base case
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            // only change in while for Dequeue
            res.append("/").append(s.pollLast());
        }
        return res.toString();
    }
}