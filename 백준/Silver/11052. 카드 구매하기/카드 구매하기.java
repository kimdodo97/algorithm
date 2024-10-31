import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = cards[0];

        for(int i=2; i<=N; i++){
            for(int j=1; j<=i/2; j++){
                dp[i] = Math.max((dp[j]+dp[i-j]),dp[i]);
            }

            if(cards[i-1] > dp[i]){
                dp[i] = cards[i-1];
            }
        }

        System.out.println(dp[N]);
    }
}
