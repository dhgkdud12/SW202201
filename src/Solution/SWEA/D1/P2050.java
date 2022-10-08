package Solution.SWEA.D1;

import java.util.Scanner;

public class P2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            System.out.printf("%d ", (int)c-'A'+1);
            str = str.toUpperCase();
            System.out.println(str);
        }
    }
}
