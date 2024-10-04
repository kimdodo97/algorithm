import java.util.*; 

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        
        Set<Integer> ponkets = new HashSet<>();
        
        for(int i : nums){
            ponkets.add(i);
        }
        
        if(ponkets.size() > max)
        {
            return max;
        }
        else{
            return ponkets.size();
        }
    }
}