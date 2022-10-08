package Solution.backjoon.Dijkstra.P1753;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    static int V, E, K;
    static int[] dist;
    static ArrayList<int[]> adj[];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Dijkstra/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        adj = new ArrayList[V+1];
        for (int i = 1; i <= V ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,w});
        }

        dist[K] = 0;
        dijkstra(K);

        for (int i = 1; i <= V ; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (dist[curr.v] < curr.w) continue;
            for (int next[] : adj[curr.v]) {
                if (dist[next[0]] > curr.w + next[1] ) {
                    dist[next[0]] = curr.w + next[1];
                    pq.offer(new Node(next[0], dist[next[0]]));
                }
            }
        }
    }

    static public class Node implements Comparable<Node>{
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
