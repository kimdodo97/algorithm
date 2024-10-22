import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> userReported = new HashMap<>();
        Map<String,Set<String>> userReportIds = new HashMap<>();
        
        for(String userId : id_list){
            userReported.put(userId,0);
            userReportIds.put(userId,new HashSet<>());
        }
        
        for(int i=0; i<report.length; i++){
            String[] data = report[i].split(" ");
            String userId = data[0];
            String reported = data[1];
            
            Set<String> reportIds = userReportIds.get(userId);
            if(!reportIds.contains(reported)){
                reportIds.add(reported);
                int cnt = userReported.get(reported) + 1;
                userReported.replace(reported,cnt);
            }
            
        }
        
        
        for(int i=0; i<id_list.length; i++){
            Set<String> reportIds = userReportIds.get(id_list[i]);
            for(String id : reportIds){
                int count = userReported.get(id);
                if(count >= k){
                    answer[i] = answer[i] + 1;
                }
            }
        }
        return answer;
    }
}
