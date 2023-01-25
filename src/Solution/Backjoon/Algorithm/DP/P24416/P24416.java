package Solution.Backjoon.Algorithm.DP.P24416;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24416 {
    static int N, c1, c2;
    static int[] f;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/DP/P24416/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fib(N);
        f = new int[N];
        f(N);

        System.out.println(c1);
        System.out.println(c2+1);
    }
    public static int fib(int n) {
        if (n==1 || n==2) {
            ++c1;
            return 1;
        }
        else return fib(n-1) + fib(n-2);
    }

    public static void f(int n) {
        if (n == 1 || n == 2)  f[n] = 1;
        for (int i = 3; i < n; i++) {
            ++c2;
            f[i] = f[i-1] + f[i-2];
        }
    }
}
