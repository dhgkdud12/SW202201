package Solution.backjoon.P24479;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P24479 {
    static int N, M, R, idx;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P24479/input.txt"));
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

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }

    }

    static void dfs(int r) {
        visited[r] = true;
        answer[r] = ++idx;
        for (int i = 0; i < adj[r].size() ; i++) {
            int next = adj[r].get(i);
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }

    }
}
