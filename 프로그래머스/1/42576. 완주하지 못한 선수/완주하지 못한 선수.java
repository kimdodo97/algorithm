import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> person = new HashMap<>();
        
        for(String part : participant){
            if(person.containsKey(part)){
                Integer curr = person.get(part);
                person.replace(part,curr+1);
            }else{
                person.put(part,1);
            }
        }
        
        for(String complete : completion){
            Integer curr = person.get(complete);
            curr -= 1;
            person.replace(complete,curr);
            
            if(person.get(complete) <=0 ){
                person.remove(complete);
            }
        }
        
        for (String s : person.keySet()) {
            answer = s;
        }
        
        return answer;
    }
}