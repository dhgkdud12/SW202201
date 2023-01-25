package Solution.SWEA.D2.P1979;

import java.io.*;
import java.util.StringTokenizer;

public class P1979 {
    static int T, N, K;
    static int[][] graph;
    static boolean[][] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1979/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            // 가로
            int rwcnt = 0;
            for (int j = 0; j < N; j++) {
                rwcnt = 0;
                for (int k = 0; k < N; k++) {
                    if (graph[j][k] == 1) {
                        rwcnt++;
                    } else if (graph[j][k] == 0){
                        if (rwcnt == K) {
                            cnt++;
                        }
                        rwcnt = 0;
                    }

                    if (rwcnt == K && k == (N-1)) {
                        cnt++;
                    }

                }
            }

            // 세로
            int clcnt = 0;
            for (int j = 0; j < N; j++) {
                clcnt = 0;
                for (int k = 0; k < N; k++) {
//                    System.out.print(graph[k][j] + " ");
                    if (graph[k][j] == 1) {
                        clcnt++;
                    } else if (graph[k][j] == 0){
                        if (clcnt == K) {
                            cnt++;
                        }
                       clcnt = 0;
                    }

                    if (clcnt == K && k == (N-1)) {
                        cnt++;
                    }
                }
//                System.out.println();
            }

            System.out.println("#"+(i+1)+" "+cnt);

        }
    }


}
