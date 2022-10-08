package Solution.SWEA.D1;

import java.util.Scanner;

public class P2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int t = n;
        int total = 0;
        while (t > 0) {
            total += t%10;
            t /= 10;
        }
        System.out.println(total);
    }
}
