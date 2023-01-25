package Solution.SWEA.D2.P1959;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1959 {
    static int T, N, M, MAX;
    static int[] A, B;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1959/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            MAX = 0;
            if (N < M) {
                for (int j = 0; j < M-N+1; j++) {
                    int result = 0;
                    for (int k = 0; k < N; k++) {
                        result += A[k] * B[k+j];
//                        System.out.println(A[k] + " " + B[k+j]);
                    }
                    MAX = Math.max(MAX, result);
                };
            } else if (N > M) {
                for (int j = 0; j < N-M+1; j++) {
                    int result = 0;
                    for (int k = 0; k < M; k++) {
                        result += A[k+j] * B[k];
                    }
                    MAX = Math.max(MAX, result);
                };
            } else if (N == M) {
                for (int j = 0; j < N; j++) {
                    MAX += A[j] * B[j];
                }
            }
            System.out.println("#"+(i+1)+" "+MAX);
        }
    }
}
