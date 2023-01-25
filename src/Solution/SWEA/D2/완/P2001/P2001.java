package Solution.SWEA.D2.완.P2001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2001 {
    static int[] dx, dy;
    static int T, N, M, max;
    static StringTokenizer st;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P2001/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dx = new int[M*M];
            dy = new int[M*M];
            int d = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    dx[d] = j;
                    dy[d] = k;
                    d++;
                }
            }
//            System.out.println(Arrays.toString(dx));
//            System.out.println(Arrays.toString(dy));

            max = 0;
            bfs();
            System.out.println("#"+(i+1)+" "+max);

        }
    }
    static public void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int cur = 0;

        for (int i = 0; i <= N-M ; i++) {
            for (int j = 0; j <= N-M; j++) {
//                System.out.print(arr[i][j]);
                q.offer(new int[]{i, j});
            }
        }


        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];
            cur = arr[cx][cy];
             for (int i = 1; i < M*M; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    cur += arr[nx][ny];
//                 System.out.print(cur+" ");
            }
//            System.out.println(cur);

            max = Math.max(max, cur);
            
        }
    }
}
