package Solution.Backjoon.Step.P3003;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P3003 {
    public static void main(String[] args) {

        int[] arr = new int[6];
        int[] chess = {1, 1, 2, 2, 2, 8};

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str);


        for (int i = 0; i < arr.length; i++) {
            String s = st.nextToken(" ");
            arr[i] = Integer.parseInt(s);
            System.out.print(chess[i] - arr[i] + " ");
        }

    }
}
