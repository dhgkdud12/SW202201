package SDS.DAY07.P1753;

import java.io.*;
import java.util.*;

// 최단경로
// 다익스트라 알고리즘
public class P1753 {
    static int N, M, K;
    static ArrayList<int[]> adj[];
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 시작번호

        adj = new ArrayList[N+1]; // 그래프
        dist = new int[N+1]; // 거리

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<int[]>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[] {v, w});
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Route> pq = new PriorityQueue<Route>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        pq.offer(new Route(K, 0));
        while(!pq.isEmpty()) {
            Route curr = pq.poll();
            if(dist[curr.v] < curr.w) continue;
            for(int[] next : adj[curr.v]) { // 최단거리 찾기
                if (dist[next[0]] > curr.w + next[1]) { // 0: 정점, 1: 가중치
                    dist[next[0]] = curr.w + next[1];
                    pq.offer(new Route(next[0], dist[next[0]]));
                }
            }
        }
    }
    public static class Route implements Comparable<Route>{
        int v, w; // 정점, 가중치
        public Route(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Route o) {
            return o.w - this.w;
        }
    }
}