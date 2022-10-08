package Solution.SWEA.D1.P2072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2072 {
    static int T, total;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D1/P2072/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            total = 0;
            for (int j = 0; j < 10; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (isOdd(n)) total += n;
            }
            System.out.println("#"+(i+1)+" "+total);
        }
    }

    public static boolean isOdd(int n) {
        if (n%2!=0) return true;
        return false;
    }
}
