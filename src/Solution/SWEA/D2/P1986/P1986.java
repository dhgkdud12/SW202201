package Solution.SWEA.D2.P1986;

import java.io.*;

public class P1986 {
    static int T, N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1986/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int result = 0;
            for (int j = 1; j <= N ; j++) {
                if (check(j) == 1) result -= j;
                else if (check(j) == 2) result += j;
            }

            System.out.println("#"+(i+1)+" "+result);
        }
    }

    public static int check(int num) {
        if (num % 2 == 0) return 1;
        else return 2;
    }
}
