package Solution.Backjoon.PS.P1654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
    static int K, N;
    static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        long start = 1, mid = 0, value;
        long end = line[line.length-1];

        while (true) {
            mid = (start + end) / 2;
            value = calc(mid);

            if (value >= N) {
                start = mid + 1;
            } else if (value < N) {
                end = mid - 1;
            }

            if (start > end) {
                break;
            }

        }

        System.out.println(end);

    }

    static long calc(long a) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += line[i]/a;
        }
        return count;
    }
}
