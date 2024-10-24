import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        if(cacheSize==0){
            return cities.length * 5;
        }
    
        for(int i=0; i<cities.length; i++){
            String currentCity = cities[i].toLowerCase();
            if(cache.contains(currentCity)){
                cache.remove(currentCity);
                cache.add(currentCity);
                answer++;
            }else{
                if(cache.size()==cacheSize){
                    cache.remove(0);
                } 
                cache.add(currentCity);
                answer+=5;
            }
        }
        return answer;
    }
}