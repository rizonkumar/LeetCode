class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'G'){
                sb.append("G");
            }
            else if(command.charAt(i) == '('){
                // after '(' there is two choice one is '(' other is 'al'
                if(command.charAt(i + 1) == ')') { // if next is ')' that is i + 1
                    sb.append("o");
                } else {
                    sb.append("al"); // else al
                }
            }
        }
        return sb.toString();
    }
}