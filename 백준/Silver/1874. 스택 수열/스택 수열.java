import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        int current = 1;
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            while(current <= number){
                st.add(current);
                answer.add("+");
                current++;
            }

            if(st.peek() == number){
                st.pop();
                answer.add("-");
            }else{
                System.out.println("NO");
                break;
            }
        }

        if(st.empty()){
            answer.stream().forEach(System.out::println);
        }
    }
}
