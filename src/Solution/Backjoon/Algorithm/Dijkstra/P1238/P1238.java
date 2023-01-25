package Solution.Backjoon.Algorithm.Dijkstra.P1238;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1238 {
    static int N, M, X, ans;
    static ArrayList<int[]> adj[], reverse_adj[];
    static int[] dist1, dist2;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Dijkstra/P1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist1 = new int[N+1];
        dist2 = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }

        adj = new ArrayList[N+1];
        reverse_adj = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            adj[i] = new ArrayList<>();
            reverse_adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[start].add(new int[]{end, t});
            reverse_adj[end].add(new int[]{start, t});
        }

        dist1[X] = 0;
        dist2[X] = 0;
        dijkstra(adj, dist1);
        dijkstra(reverse_adj, dist2);

        for (int i = 1; i <= N ; i++) {
            ans = Math.max(dist1[i]+dist2[i], ans);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(ArrayList<int[]> a[], int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (dist[curr.v] < curr.t) continue;
            for (int[] next : a[curr.v]) {
                if (dist[next[0]] > curr.t + next[1] ) {
                    dist[next[0]] = curr.t + next[1];
                    pq.offer(new Node(next[0], dist[next[0]]));
                }
            }
        }
    }
    public static class Node implements Comparable<Node>{
        int v, t;
        public Node(int v, int t) {
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return o.t - this.t;
        }
    }
}
