class Solution {
    public int lastStoneWeight(int[] stones) {
 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> (b-a)); //Max heap (b -a) responsible for it
        for(int stone: stones){
            pq.offer(stone);
        }
        
        while(pq.size() > 1){
            int largestEl = pq.poll();
            int secondlargestEl = pq.poll();
            // condition given in question
            if(largestEl == secondlargestEl){
                continue;
            } else {
                int diff = largestEl - secondlargestEl;
                pq.offer(diff);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}