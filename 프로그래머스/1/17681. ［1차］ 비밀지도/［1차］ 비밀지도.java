class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String num1 = Integer.toBinaryString(arr1[i]);
            if(num1.length()<n){
                int diff = n - num1.length();
                for(int j=0; j<diff; j++){
                    num1 = "0" + num1;
                }
            }
            
            String num2 = Integer.toBinaryString(arr2[i]);
            if(num2.length()<n){
                int diff = n - num2.length();
                for(int j=0; j<diff; j++){
                    num2 = "0" + num2;
                }
            }
            
            String result = "";
            for(int j=0; j<n; j++){
                if(num1.charAt(j) == '1' || num2.charAt(j) == '1'){
                    result += "#";
                }else{
                    result += " ";
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}