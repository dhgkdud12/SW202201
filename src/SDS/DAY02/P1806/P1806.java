package SDS.DAY02.P1806;

import java.io.*;
import java.util.StringTokenizer;

public class P1806 {
    static int N, S = 0;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SDS.DAY02/P1806/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N+1]; // out index 방지, 곱일 때는 마지막 원소 1로 만들어야함

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = nums[0], minLen = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLen = Math.min((high - low) + 1, minLen);
                sum -= nums[low++];
            }
            else if (sum < S) {
                sum += nums[++high];
            }

            if (high == N) {
                break;
            }
        }

        if (minLen == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(minLen);

    }
}
