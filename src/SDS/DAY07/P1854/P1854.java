package SDS.DAY07.P1854;

import java.io.*;
import java.util.*;

// K번째 최단경로 찾기
// 다익스트라
// 1번에서 시작
public class P1854 {
    static int N, M, K;
    static ArrayList<int[]> adj[];
    static List<Integer> dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //  도시들의 개수, V
        M = Integer.parseInt(st.nextToken()); // 도로의 수, E
        K = Integer.parseInt(st.nextToken()); // K번째

        adj = new ArrayList[N+1]; // 정점
        dist = new ArrayList[N+1]; // 거리

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<int[]>();
            dist[i] = new ArrayList<Integer>();
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
            sb.append(dist[i].size() == K ? dist[i].get(K-1) : -1).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dijkstra() {
        PriorityQueue<Route> pq = new PriorityQueue<Route>(); //
        pq.offer(new Route(1, 0));
        int doneCnt = 0;
        while(!pq.isEmpty()) {
            Route curr = pq.poll();
            if (dist[curr.v].size() < K) dist[curr.v].add(curr.w);
            else continue;
            if (dist[curr.v].size() == K) doneCnt++;
            if (doneCnt == N) break; // 다 찾았으면 끝내기
            for(int[] next : adj[curr.v]) {
                int v = next[0];
                int c = next[1];
                int tc = curr.w + c;
                if (dist[v].size() < K) {
                    pq.offer(new Route(v, tc)); // pq에 집넣
                }
            }
        }
    }
    public static class Route implements Comparable<Route>{
        int v, w;
        public Route(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Route o) {
            return this.w - o.w; // 오름차순
        }
    }
}