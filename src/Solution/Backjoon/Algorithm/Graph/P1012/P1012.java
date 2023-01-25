package Solution.Backjoon.Algorithm.Graph.P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {
    static int T, M, N, K;
    static int[][] cabage;
    static boolean[][] visit;
    static int count;
    static StringTokenizer st;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph//P1012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            cabage = new int[M][N];
            visit = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());


            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabage[x][y] = 1;
            }

            count = 0;
            for (int i = 0; i < M; i++) { // 가로
                for (int j = 0; j < N; j++) { // 세로
                    if (cabage[i][j] == 1 && !visit[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }


    }

    static public void dfs(int x, int y) {
        visit[x][y] = true; // 방문표시

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (cabage[cx][cy] == 1 && !visit[cx][cy]) {
                    dfs(cx, cy);
                }
            }
        }

    }
}
