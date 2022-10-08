package DAY07.P2458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 키 순서
// 그래프이론 OR 플로이드워셜
public class P2458 {
    static int N, M, inCnt[], outCnt[];
    static ArrayList<Integer> adj[];
    static boolean visited[];
    static int dfs(int curr) {
        int outCnt = 0;
        for (int next : adj[curr]) {
            if (visited[next]) {
                continue;
            }
            inCnt[next]++;
            visited[next] = true;
            outCnt += dfs(next);
        }
        return outCnt+1;
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY07/P2458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];

        inCnt = new int[N+1]; // 해당 정점의 방문 순서
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        outCnt = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            visited = new boolean[N+1];
            outCnt[i] = dfs(i)-1; // 해당 정점을 벗어날 때 방문 순서
        }

        for (int i = 1; i <= N; i++) {
            System.out.println("inCnt, outCnt" + inCnt[i] +" " + outCnt[i]);
        }

        int answer = 0;
        for (int i = 1; i <= N ; i++) {
            if ((inCnt[i] + outCnt[i]) == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
