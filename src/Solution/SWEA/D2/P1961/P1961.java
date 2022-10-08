package Solution.SWEA.D2.P1961;

import java.io.*;
import java.util.StringTokenizer;

public class P1961 {
    static int T, N;
    static String[][] arr, result;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new String[N][N];
            result = new String[N][3];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = st.nextToken();
                }
            }

            rotation();

            System.out.println("#"+(i+1));
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(result[j][k] + " ");
                }
                System.out.println();
            }

        }
    }
    
    static public void rotation() {

        int x = 0;
        // 90도 회전
        for (int i = 0; i < N; i++) {
            String s = "";
            for (int j = N-1; j >= 0 ; j--) {
                s += arr[j][i];
            }
            result[x++][0] = s;
        }

        // 180도 회전
        x = 0;
        for (int i = N-1; i >= 0; i--) {
            String s = "";
            for (int j = N-1; j >= 0 ; j--) {
                s += arr[i][j];
            }
                result[x++][1] = s;
        }

        // 270도 회전
        x = 0;
        for (int i = N-1; i >= 0; i--) {
            String s = "";
            for (int j = 0; j < N ; j++) {
                s += arr[j][i];
            }
                result[x++][2] = s;
        }
    }
}
