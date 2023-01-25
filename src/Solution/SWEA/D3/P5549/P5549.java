package Solution.SWEA.D3.P5549;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P5549 {
    static int T;
    static String str;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D3/P5549/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            str = br.readLine();
            int n = Integer.parseInt(str.substring(str.length()-1));
            if (n%2==0) System.out.println("#"+(i+1)+" "+"Even");
            else System.out.println("#"+(i+1)+" "+"Odd");
        }

    }
}
