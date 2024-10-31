import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String,Integer> skillMap = new HashMap<>();
        
        for(String skills : skill_trees){
            String check = "";
            for(int i=0; i<skills.length(); i++){
                String now = String.valueOf(skills.charAt(i));
                if(skill.contains(now)){
                    check = check + now;
                }
            }
            if(check.equals(skill.substring(0,check.length()))){
                answer++;
            }              
        }
        return answer;
    }
}