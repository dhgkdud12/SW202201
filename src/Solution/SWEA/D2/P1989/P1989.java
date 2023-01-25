package Solution.SWEA.D2.P1989;

import java.io.*;

public class P1989 {
    static int T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1989/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            System.out.print("#"+(i+1)+" ");
            if (check(str)) System.out.println(1);
            else System.out.println(0);
        }
    }

    public static boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
