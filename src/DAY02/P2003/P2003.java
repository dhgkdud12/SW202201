package DAY02.P2003;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2003 {
    static int N;
    static int M;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY02/P2003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = nums[0], count = 0;
        while (true) {
            // sum == M -> 답, low++
            if (sum == M) {
                count++;
                sum -= nums[low++];
            }
            // sum > M -> low++
            else if (sum > M) {
                sum -= nums[low++];
            }
            // sum < M -> high++
            else if (sum < M) {
                sum += nums[++high];
            }

            if (high == N) { // 탈출조건
                break;
            }
        }

        System.out.println(count);

    }
}
