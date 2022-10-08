package Solution.SWEA.D2.P1966;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1966 {
    static int T, N;
    static int[] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            System.out.print("#"+(i+1) + " ");
            for (int j = 0; j < N; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}
