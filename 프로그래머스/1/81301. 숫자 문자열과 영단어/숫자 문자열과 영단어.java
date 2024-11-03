import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> numberMap = new HashMap<>();
        numberMap.put("zero","0");
        numberMap.put("one","1");
        numberMap.put("two","2");
        numberMap.put("three","3");
        numberMap.put("four","4");
        numberMap.put("five","5");
        numberMap.put("six","6");
        numberMap.put("seven","7");
        numberMap.put("eight","8");
        numberMap.put("nine","9");
        
        Set<String> numbers = numberMap.keySet();
        
        for(String number : numbers){
            if(s.contains(number)){
                s = s.replace(number,numberMap.get(number));
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}