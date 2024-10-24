import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();

        for(int i=0; i<n; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp,99999);
        dp[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=coins.get(i); j<=k; j++){
                dp[j] = Math.min(dp[j],dp[j-coins.get(i)]+1);
            }
        }

        if(dp[k] == 99999){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[k]);
        }
    }
}
