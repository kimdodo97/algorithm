import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[][] move = {{0,-1},{0,1},{1,0},{-1,0}};
    static int n;
    static int count = 1;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            String[] data = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]&&map[i][j]!=0){
                    findLand(i,j);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != 0){
                    visit = new boolean[n][n];
                    solve(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void findLand(int x, int y){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{x,y});
        visit[x][y] = true;
        map[x][y] = count;
        while(!Q.isEmpty()){
            int[] now = Q.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + move[i][0];
                int ny = now[1] + move[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny]==1){
                    Q.offer(new int[]{nx,ny});
                    visit[nx][ny] = true;
                    map[nx][ny] = count;
                }
            }
        }
        count++;
    }

    public static void solve(int x,int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y,0));
        int nowLand = map[x][y];
        visit[x][y] = true;

        while(!Q.isEmpty()){
            Point now = Q.poll();
            for(int i=0; i<4; i++){
                int nx = now.x + move[i][0];
                int ny = now.y + move[i][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && map[nx][ny]!=nowLand){
                    visit[nx][ny] = true;
                    if(map[nx][ny] == 0){
                        Q.offer(new Point(nx,ny,now.distance+1));
                    }else{
                        answer = Math.min(answer,now.distance);
                    }
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        int distance;

        public Point(int x,int y, int distance){
            this.x= x;
            this.y=y;
            this.distance=distance;
        }
    }
}
