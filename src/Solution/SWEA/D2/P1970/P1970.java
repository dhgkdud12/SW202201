package Solution.SWEA.D2.P1970;

import java.io.*;
import java.nio.Buffer;

public class P1970 {
    static int T, N;
    static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] count;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1970/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            count = new int[8];
            int c = 0;
            int v = N;
            while (v > 0) {
                int m = v/money[c];
                count[c] = m;
                v -= (money[c]*m);
                c++;
            }

            System.out.println("#"+(i+1));
            for (int j = 0; j < 8; j++) {
                System.out.print(count[j] + " ");
            }
            System.out.println();


        }
    }
}
