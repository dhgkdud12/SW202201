package Solution.Backjoon.Algorithm.Graph.P10026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10026 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static char[][] ch, rgm;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph/P10026/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ch = new char[N][N];
        rgm = new char[N][N]; //적록색약

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = st.charAt(j);
                ch[i][j] = c;
                if (c == 'R') rgm[i][j] = 'G';
                else rgm[i][j] = st.charAt(j);
            }
        }

        System.out.println(area(ch));
        System.out.println(area(rgm));

    }

    static public int area(char[][] ch) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i,j,ch, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static public void bfs (int x, int y, char[][] ch, boolean[][] visited) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cx = arr[0];
            int cy = arr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && (ch[cx][cy] == ch[nx][ny])) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny});
                }
            }
        }
    }
}
