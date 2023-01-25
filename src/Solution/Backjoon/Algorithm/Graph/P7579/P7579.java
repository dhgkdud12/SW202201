package Solution.Backjoon.Algorithm.Graph.P7579;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7579 {
    static int[] dx = {-1,0,1,0,0,0}; // 상하좌우위아래
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static StringTokenizer st;
    static int M, N, H ,day;
    static int box[][][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph/P7579/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        H = Integer.parseInt(st.nextToken()); // 높이
        
        box = new int[N][M][H];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[i][j][h] = Integer.parseInt(st.nextToken());
                }
            }
        }


        bfs();


//        for (int h = 0; h < H; h++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(box[i][j][h] + " ");
//                }
//                System.out.println("");
//            }
//        }

        if (check()) {
            System.out.println(day-1);
        } else {
            System.out.println(-1);
        }

    }

    // 안익은 토마토 있는지 확인
    static public boolean check() {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    day = Math.max(day, box[i][j][h]);
                    if (box[i][j][h] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static public void bfs () {
        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[i][j][h] == 1) {
                        q.offer(new int[]{i,j,h});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ch = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nh = ch + dz[i];


                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < N && ny < M && nh < H) {
                    if (box[nx][ny][nh] == 0) {
                        box[nx][ny][nh] = box[cx][cy][ch] + 1;
                        q.offer(new int[]{nx,ny,nh});
                    }
                }
            }
        }
    }
}
