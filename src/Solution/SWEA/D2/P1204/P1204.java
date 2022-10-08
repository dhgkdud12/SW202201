package Solution.SWEA.D2.P1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1204 {
    static int T, N, max;
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1204/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000; j++) {
                int c = Integer.parseInt(st.nextToken());
                arr[c]++;
            }

            max = 0;
            for (int j = 100; j >= 0; j--) {
                max = Math.max(arr[j], max);
            }

            int idx = 0;
            for (int j = 100; j >= 0; j--) {
                if (arr[j] == max) {
                    idx = j;
                    break;
                }
            }
            System.out.println("#"+(i+1)+" "+idx);
        }
    }
}
