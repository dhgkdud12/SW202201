package DAY06.P11438;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// LCA 2 
// 최저 공통 조상
public class Main {
    static int[][] dp;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY06/P11438/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        dp = new int[18][N + 1]; // dp[K][V] : 정점 V의 2^k번째 조상 정점 번호
        depth = new int[N + 1];
        boolean[] vst = new boolean[N + 1];
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) { // N-1
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a, b = 0;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vst[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll(); // 1
            for (int i = 0; i < adj[curr].size(); i++) { // 2
                int next = adj[curr].get(i); // 2, 3
                if (vst[next]) {
                    continue;
                }
                dp[0][next] = curr;
                vst[next] = true;
                depth[next] = depth[curr] + 1;
                q.add(next);
            }
        }

        for (int i = 1; i <= 17; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]]; // dp[i][j] : 정점 i의 2의 j번째 조상 정점 번호
            }
        }

        int M = Integer.parseInt(br.readLine()); // 공통 조상을 알고싶은 쌍의 개수
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b) + "\n");
        }
        System.out.println(sb);
    }
        static int lca(int a, int b) {
            if (depth[a] > depth[b]) {
                int tmp = b;
                b = a;
                a = tmp;
            }

            int gap = depth[b] - depth[a]; // depth 차이
            for (int i = 0; i <= 17 ; i++) {
                if ((gap & (1<<i)) > 0 ) { // 비트
                    System.out.println("i: "+i);
                    System.out.println("1<<i " + (1<<i));
                    System.out.println(gap & (1<<i));
                    b = dp[i][b];
                }
            }
            if (a==b) {
                return a;
            }
            
            // LCA 찾기
            for (int i = 17; i >= 0 ; i--) {
                if (dp[i][a] != dp[i][b]) { // 2^i 위로 올라갔을 때 서로 다르면 일단 거기로 올라감
                    a = dp[i][a];
                    b = dp[i][b];
                }
            }
            // for문을 빠져나오면 a와 b가 최소 공통 조상의 depth 한칸 밑으로 와있음.
            return dp[0][a];
    }
}
