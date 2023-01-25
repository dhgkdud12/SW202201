package Solution.SWEA.D2.완.P1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1954 {
    static int T, N, n;
    static int[] dx = {1, 0, -1, 0}; // 오, 아, 왼, 위
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            n = 1;
            visited = new boolean[N+1][N+1];
            map = new int[N+1][N+1];

            System.out.println("#"+(i+1));
            dfs(1,N, 1);

            for (int j = N; j >= 1; j--) {
                for (int k = 1; k <= N; k++) {
                    System.out.print(map[k][j]+" ");
                }
                System.out.println();
            }

        }
    }
    static public void dfs(int x, int y, int n) {
//        System.out.println(x+" "+y);
//        System.out.println(n);
        visited[x][y] = true;
        map[x][y] = n;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > N || ny > N || nx <= 0 || ny <= 0) {
                continue;
            } else {
                if (!visited[nx][ny]) {
                    dfs(nx, ny, ++n);
                }
            }
        }
    }
}
