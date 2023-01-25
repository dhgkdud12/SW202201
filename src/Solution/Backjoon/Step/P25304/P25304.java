package Solution.Backjoon.Step.P25304;

import java.util.Scanner;

public class P25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());

            int AB = a*b;
            sum += AB;
        }

        if (X == sum) {
            System.out.println("Yes");
        } else System.out.println("No");

    }
}
