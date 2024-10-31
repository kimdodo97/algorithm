import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = 1L;
            dp[2] = 1L;
            dp[3] = 1L;

            for(int i=4; i<=100; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
