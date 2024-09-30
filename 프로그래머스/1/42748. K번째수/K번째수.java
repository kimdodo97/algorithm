import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer  = new int[n];        
        for(int i=0; i<n; i++){
            int result = sliceSort(array,commands[i]);
            answer[i] = result;
        }
        
        return answer;
    }
    
    public int sliceSort(int[] arr, int[] command){
        int start = command[0] - 1;
        int end = command[1];
        int k = command[2] - 1;
        int[] tmp = Arrays.copyOfRange(arr,start,end);
        Arrays.sort(tmp);
        return tmp[k];
    }
}