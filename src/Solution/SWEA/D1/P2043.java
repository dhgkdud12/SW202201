package Solution.SWEA.D1;

import java.util.Scanner;

public class P2043 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int P = sc.nextInt();
        int K = sc.nextInt();

        int count = P-K+1;
        System.out.println(count);
    }
}
