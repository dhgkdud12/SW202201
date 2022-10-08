package Solution.backjoon.Backtracking.P15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(1, 0);

    }
    public static void dfs(int at, int K) {
        if (K == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 노드를 방문 상태로 변경
                arr[K] = i;
                dfs(i + 1, K+1);
                visited[i] = false;
            }
        }
        return;
    }
}

