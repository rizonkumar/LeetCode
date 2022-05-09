class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return (new ArrayList<>());
        return letter("",digits);
    }
    public List<String> letter(String p,String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0)-'0';
        if(digit<=1 || digit>9)return ans;
        if(digit<=6){
        for(int i=(digit-2)*3;i<((digit-1)*3);i++){
            char c = (char)('a'+ i);
            ans.addAll(letter(p+c,up.substring(1)));
        }
        }else{
            if(digit==7){
                for(int i=(digit-2)*3;i<=(digit-1)*3;i++){
                    char c = (char)('a'+ i);
                    ans.addAll(letter(p+c,up.substring(1)));
                }
            }else if(digit==8){
                for(int i=((digit-2)*3)+1;i<=(digit-1)*3;i++){
                    char c = (char)('a'+ i);
                    ans.addAll(letter(p+c,up.substring(1)));
                }
            }else{
                for(int i=((digit-2)*3)+1;i<=((digit-1)*3)+1;i++){
                    char c = (char)('a'+ i);
                    ans.addAll(letter(p+c,up.substring(1)));
                }
            }
        }
        
        return ans;
    }
}