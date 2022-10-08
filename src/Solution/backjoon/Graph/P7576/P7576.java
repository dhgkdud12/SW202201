package Solution.backjoon.Graph.P7576;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringTokenizer st;
    static int M, N ,day;
    static int box[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph/P7576/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println("");
        }

        if (check()) {
            System.out.println(day-1);
        } else {
            System.out.println(-1);
        }

    }

    // 안익은 토마토 있는지 확인
    static public boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                day = Math.max(day, box[i][j]);
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    static public void bfs () {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = box[cx][cy] + 1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }

}
