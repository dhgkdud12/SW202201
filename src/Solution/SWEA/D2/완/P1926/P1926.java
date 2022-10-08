package Solution.SWEA.D2.완.P1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N ; i++) {
            int cnt = check(i);
            if (cnt == 0) {
                System.out.print(i);
            } else {
                for (int j = 0; j < cnt ; j++) {
                    System.out.print("-");
                }
            }
            System.out.print(" ");

        }
    }

    static public int check(int n) {
        int x = n;
        int count = 0;
        while (x > 0) {
            int c = x%10;
            if (c != 0 && c%3 == 0) {
                count++;
            }
            x = x/10;
        }
        return count;
    }
}
