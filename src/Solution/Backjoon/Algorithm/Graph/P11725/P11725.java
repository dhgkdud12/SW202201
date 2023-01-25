package Solution.Backjoon.Algorithm.Graph.P11725;

import java.io.*;
import java.util.*;

public class P11725 {
    static int N;
    static StringTokenizer st;
    static int[] parent;
    static ArrayList<Integer> adj[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph/P11725/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        adj = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        bfs(1);

        for (int i = 2; i <= N ; i++) {
            sb.append(parent[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        parent[1] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < adj[c].size(); i++) {
                int n = adj[c].get(i);
                if (parent[n] == 0) {
                    parent[n] = c;
                    q.offer(n);
                }
            }
        }
    }
}
