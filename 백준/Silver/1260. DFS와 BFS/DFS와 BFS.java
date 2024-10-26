import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static LinkedList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<n+1; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i =0; i<m; i++){
            String[] data = br.readLine().split(" ");
            int node1 = Integer.parseInt(data[0]);
            int node2 = Integer.parseInt(data[1]);

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }

        DFS(start);
        visited = new boolean[n+1];
        answer = new ArrayList<>();
        System.out.println();
        BFS(start);
    }

    public static void DFS(int idx){
        visited[idx] = true;
        System.out.print(idx + " ");

        if(idx == graph.length) {
            return;
        }

        for(int node : graph[idx]){
            if(!visited[node]){
                DFS(node);
            }
        }
    }

    public static void BFS(int start){
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int nextNode : graph[now]){
                if(!visited[nextNode]){
                    queue.offer(nextNode);
                    System.out.print(nextNode + " ");
                    visited[nextNode] = true;
                }
            }
        }
    }

}