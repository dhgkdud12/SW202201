package Solution.SWEA.D2.완.P2007;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 앞 두 글자 추출
public class P2007_Solution {
    static int T;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P2007/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            for (int j = 1; j <= 10; j++) {
                String pre = str.substring(0, j);
                String next = str.substring(j, j+j);
                if (pre.equals(next)) {
                    print(i, pre.length());
                    break;
                }
            }
        }
    }

    static public void print(int i, int len) {
        System.out.println("#" + (i + 1) + " " + len);
    }
}
