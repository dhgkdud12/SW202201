package Solution.Backjoon.Algorithm.Dijkstra.P1916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {
    static int N, M;
    static int[] dist;
    static ArrayList<int[]> adj[]; // 인접리스트
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Dijkstra/P1916/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 거리 초기화
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 인접리스트 초기화
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    static public void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[k] = 0;
        pq.add(new Node(k,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (dist[curr.v] < curr.w ) continue;
            for (int[] next : adj[curr.v] ) {
                if (dist[next[0]] > curr.w + next[1]) {
                    dist[next[0]] = curr.w + next[1];
                    pq.offer(new Node(next[0], dist[next[0]]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w ;
        }
    }
}
