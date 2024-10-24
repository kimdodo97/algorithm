class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String current = s;
        while(!current.equals("1")){
            String sub = "";
            for(int i=0; i<current.length(); i++){
                char number = current.charAt(i);
                if(number == '0'){
                    answer[1]++;
                }else{
                    sub = sub + "1";
                }
            }
            current=sub;
            
            current = String.valueOf(Integer.toBinaryString(current.length()));
            answer[0]++;

        }
        return answer;
    }
}