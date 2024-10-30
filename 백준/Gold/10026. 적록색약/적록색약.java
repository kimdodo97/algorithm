import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static String[][] graph;
    static boolean[][] visit;
    static int N;
    static Queue<int[]> Q;
    static int[][] move= {{0,-1},{0,1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];
        visit = new boolean[N][N];
        Q = new LinkedList<>();
        for(int i=0; i<N; i++){
            String[] row = br.readLine().split("");
            for(int j =0; j<N; j++){
                graph[i][j] = row[j];
            }
        }

        int answer  = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    BFS(i,j);
                    answer++;
                }
            }
        }
        System.out.print(answer + " ");

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j].equals("R")){
                    graph[i][j] = "G";
                }
            }
        }

        answer  = 0;
        visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    BFS(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void BFS(int x, int y){
        Q.offer(new int[]{x,y});
        visit[x][y]= true;

        while(!Q.isEmpty()){
            int[] now = Q.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0] + move[i][0];
                int nextY = now[1] + move[i][1];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && Objects.equals(graph[x][y], graph[nextX][nextY]) && !visit[nextX][nextY]){
                    Q.offer(new int[]{nextX,nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }
    }
}
