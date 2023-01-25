package Solution.SWEA.D2.P1948;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1948 {

    static int T;
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1948/input.txt"));

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();

            int m2 = sc.nextInt();
            int d2 = sc.nextInt();

            int m_diff = m2 - m1;
            int m = m1;

            int result = 0;

            if (m_diff > 0) {
                for (int j = 1; j < m_diff ; j++) {
                    result += days[m+1];
                    m++;
                }

                result += (days[m1] - d1 + 1) + d2;
            } else {
                result = d2 - d1 + 1;
            }

            System.out.println("#" + i + " " + result);


        }

    }
}
