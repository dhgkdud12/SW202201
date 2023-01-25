package Solution.Backjoon.Step.P1712;

import java.util.Scanner;

public class P1712 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (b >= c) {
            System.out.println(-1);
        } else {
            System.out.println(a/(c-b)+1); // 손익분기점 공식
        }
    }
}
