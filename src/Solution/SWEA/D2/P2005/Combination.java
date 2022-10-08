package Solution.SWEA.D2.P2005;

import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        int result = factorial(n)/(factorial(r)*factorial(n-r));
        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        else return n*factorial(n-1);
    }
}
