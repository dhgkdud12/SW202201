package Solution.SWEA.D2.P2005;

import java.io.*;

public class P2005 {
    static int T, N;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P2005/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            init();
            for (int j = 1; j < N ; j++) {
                for (int k = 1; k < N; k++) {
                    // 조합 특성 : n-1Cr-1 + n-1Cr = nCr
                    matrix[j][k] = matrix[j-1][k-1]+matrix[j-1][k];
                }
            }

            System.out.println("#"+ (i+1));

            for (int j = 0; j < N ; j++) {
                for (int k = 0; k <= j; k++) {
                    System.out.print(matrix[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void init() { // 초기화
        for (int i = 0; i < N; i++) {
            matrix[i][0] = 1;
        }
    }
}
