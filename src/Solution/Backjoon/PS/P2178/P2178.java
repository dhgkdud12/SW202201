package Solution.Backjoon.PS.P2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int N, M;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0 ,0}; // 상, 하, 좌, 우
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M ; j++) {
                miro[i][j] = s.charAt(j-1) - '0';
            }
        }

        visited[1][1] = true;
        bfs(1,1);
        System.out.println(miro[N][M]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 1 || nextY < 1 || nextX > N || nextY > M)
                    continue;
                if (visited[nextX][nextY] || miro[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                miro[nextX][nextY] = miro[nowX][nowY] + 1;

                }

            }

        }
}
