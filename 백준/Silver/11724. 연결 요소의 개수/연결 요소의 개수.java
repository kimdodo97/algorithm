import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph; //인접리스트 방식
    static boolean visited[];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i=0; i<N; i++) {//노드번호가 1부터라서 1부터 할당함
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(graph[a-1] == null){
                graph[a-1] = new ArrayList<>();
            }

            if(graph[b-1] == null){
                graph[b-1] = new ArrayList<>();
            }
            graph[a-1].add(b-1);
            graph[b-1].add(a-1);
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            if (!visited[i]){
                BFS(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void BFS(int start){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);
        visited[start] = true;
        while(!Q.isEmpty()){
            Integer current = Q.poll();
            for(int next : graph[current]){
                if(!visited[next]){
                    Q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
