package Solution.backjoon.Backtracking.P15651;

import java.io.*;
import java.util.StringTokenizer;

public class P15652 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1,0);
        bw.flush();
        bw.close();

    }
    public static void dfs(int at, int K) throws IOException {
        if (K == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
                arr[K] = i;
                dfs(i, K+1);
        }
        return;
    }
}

