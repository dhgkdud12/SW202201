package Solution.SWEA.D2.완.P1859;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1859 {
    static int T, N;
    static long max, result;
    static int[] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1859/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            max = 0;
            result = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[j], max);
            }

            if (arr[0] == max) {
                result = 0;
                System.out.println("#"+(i+1)+" "+0);
            } else {
                int x = 0;
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (max != arr[j]) {
                        x += arr[j];
                        count++;
                    }
                    else {
                        if (count != 0) result += (arr[j]*count) - x;
                        x = 0;
                        count = 0;
                        max = 0;
                        for (int k = j+1; k < N; k++) {
                            max = Math.max(max, arr[k]);
                        }
                    }
                }
                System.out.println("#"+(i+1)+" "+result);
            }
        }
    }
}
