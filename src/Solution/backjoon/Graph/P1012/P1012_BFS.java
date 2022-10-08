package Solution.backjoon.Graph.P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012_BFS {
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
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (cabage[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }


    }

    static public void bfs(int x, int y) {
        visit[x][y] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cx = arr[0];
            int cy = arr[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (cabage[nx][ny] == 1 && !visit[nx][ny]) {
                        q.offer(new int[]{nx,ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}
