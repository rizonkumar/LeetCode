class Solution {
    public double average(int[] salary) {
        double sum = 0d;
        Arrays.sort(salary);
        int count = 0;
        
        for(int i = 1; i < salary.length - 1; i++){
            sum += salary[i];
            count++;
        }
        
        return sum / count;
    }
}