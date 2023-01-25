package Solution.Backjoon.PS.P24444;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24444 {
    static int N, M, R, idx;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P24444/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(answer, 0);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N ; i++) {
            Collections.sort(adj[i], Collections.reverseOrder());
        }

        bfs(R);
        idx = 1;
        answer[R] = idx;

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        visited[r] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            answer[u] = ++idx;
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (visited[v]) continue;
                visited[v] = true;
                q.offer(v);
            }
        }
    }

}

