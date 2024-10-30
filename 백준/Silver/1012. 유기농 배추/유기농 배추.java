import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visit;
    static int N;
    static int M;
    static int K;
    static Queue<int[]> Q;
    static int[][] move= {{0,-1},{0,1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Q = new LinkedList<>();

            graph = new int[M][N];
            visit = new boolean[M][N];
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                graph[row][col] = 1;
            }

            int answer = 0;
            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(!visit[x][y] && graph[x][y] != 0){
                        solve(x,y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void solve(int x, int y){
        Q.offer(new int[]{x,y});
        visit[x][y] = true;
        while(!Q.isEmpty()){
            int[] now = Q.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + move[i][0];
                int nextY = now[1] + move[i][1];
                if(nextX>=0 && nextY>=0 && nextX<M && nextY<N && !visit[nextX][nextY] && graph[nextX][nextY] != 0){
                    Q.offer(new int[]{nextX,nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }
    }
}
