import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i=0; i<n; i++){
            String data = bf.readLine();
            Stack<Character> st = new Stack<>();
            for(int j=0; j<data.length(); j++){
                char current = data.charAt(j);
                if(current=='('){
                    st.add(current);
                }else if(current == ')'){
                    if(!st.empty()){
                        st.pop();
                    }else{
                        st.add(current);
                        break;
                    }
                }
            }

            if(st.empty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
