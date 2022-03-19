class FreqStack {

    HashMap<Integer, LinkedList<Integer>> st;
    HashMap<Integer, Integer> fmap;
    int maxFreq;
    
    public FreqStack(){
        st = new HashMap<>();
        fmap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val){
        int cFreq = fmap.getOrDefault(val,0);
        cFreq++;
        fmap.put(val,cFreq);

        if(st.containsKey(cFreq)==false){
            st.put(cFreq, new LinkedList<Integer>());
        }

        st.get(cFreq).addFirst(val);
        maxFreq = Math.max(maxFreq, cFreq);
    }

    public int pop(){
        int ans = st.get(maxFreq).removeFirst();
        int cFreq = fmap.get(ans);
        cFreq--;
        fmap.put(ans, cFreq);

        if(st.get(maxFreq).size()==0){
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */