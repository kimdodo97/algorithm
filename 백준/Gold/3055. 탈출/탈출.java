import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visit;
    static Queue<int[]> water =  new LinkedList<>();
    static String[][] graph;
    static int[][] move = {{0,-1},{0,1},{1,0},{-1,0}};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new String[R][C];

        for(int i=0; i<R; i++){
            String row = br.readLine();
            for(int j=0; j<C; j++){
                String data = String.valueOf(row.charAt(j));

                if(data.equals("S")){
                   queue.offer(new int[]{i, j});
                }

                if(data.equals("*")){
                    water.offer(new int[]{i,j});
                }
                graph[i][j] = data;
            }
        }

        int answer = bfs();
        if(answer == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(answer);
        }
    }

    public static int bfs(){
        int answer = 0;
        while(!queue.isEmpty()){
            answer++;
            int size = water.size();
            for(int k=0; k<size; k++){
                int[] waterCurrent = water.poll();
                for(int i=0; i<4; i++){
                    int nextX = waterCurrent[0] + move[i][0];
                    int nextY = waterCurrent[1] + move[i][1];

                    if((nextX >=0 && nextY>=0 && nextX < R && nextY < C) && (graph[nextX][nextY].equals(".") || graph[nextX][nextY].equals("S"))){
                        graph[nextX][nextY] = "*";
                        water.offer(new int[]{nextX,nextY});
                    }
                }
            }

            size = queue.size();
            for(int k=0; k<size; k++) {
                int[] beaber = queue.poll();
                for(int i=0; i<4; i++){
                    int nextX = beaber[0] + move[i][0];
                    int nextY = beaber[1] + move[i][1];

                    if(nextX >=0 && nextY>=0 && nextX < R && nextY < C){
                        if(graph[nextX][nextY].equals(".")){
                            graph[nextX][nextY] = "S";
                            queue.offer(new int[]{nextX,nextY});
                        }else if(graph[nextX][nextY].equals("D")){
                            return answer;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
