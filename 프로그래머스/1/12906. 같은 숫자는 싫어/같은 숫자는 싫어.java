import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> st = new Stack();
        
        for(int i : arr){
            if(st.empty() || st.peek() != i){
                st.push(i);
            }
        }
        
        answer = st.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        return answer;
    }
}