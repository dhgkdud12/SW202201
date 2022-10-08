package Solution.SWEA.D2.P1974;

import java.io.*;
import java.util.StringTokenizer;

public class P1974 {
    static int T;
    static StringTokenizer st;
    static int[][] puzzle;
    static int[] check;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1974/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            puzzle = new int[9][9];

            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    puzzle[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            if (rowCheck() && colCheck() && gridCheck()) {
                System.out.println("#"+(i+1)+" "+ 1);
            } else System.out.println("#"+(i+1)+" "+ 0);
        }
    }

    // 가로 체크
    static public boolean rowCheck() {
        for (int i = 0; i < 9; i++) {
            int[] checkArr = new int[10];
            for (int j = 0; j < 9; j++) {
                int a = puzzle[i][j];
                if (checkArr[a] == 0) checkArr[a]++;
                else {
                    return false;
                }
            }
        }

        return true;
    }

    // 세로 체크
    static public boolean colCheck() {

        for (int i = 0; i < 9; i++) {
            int[] checkArr = new int[10];
            for (int j = 0; j < 9; j++) {
                int a = puzzle[j][i];
                if (checkArr[a] == 0) checkArr[a]++;
                else return false;
            }
        }

        return true;
    }

    // 격자 체크
    static public boolean gridCheck() {

        for (int i = 0; i < 9; i=i+3) {
            for (int j = 0; j < 9; j=j+3) {
                int[] checkArr = new int[10];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int a = puzzle[i+k][j+l];
                        if (checkArr[a] == 0) {
                            checkArr[a]++;
                        }
                        else return false;
                    }
                }
            }
        }

        return true;
    }
}
