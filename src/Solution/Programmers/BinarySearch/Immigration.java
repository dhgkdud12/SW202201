package Solution.Programmers.BinarySearch;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        Immigration s = new Immigration();
        System.out.println(s.solution(n, times));

    }
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times); // 정렬
        long start = 1;
        long end = (long)times[times.length - 1] * n;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;
            for(int time : times) {
                sum += mid/time;
            }

            if (sum >= n) { // 시간 줄일 수 있음
                end = mid - 1;
                answer = mid;
            } else{ // 시간을 늘려야 함.
                start = mid + 1;
            }
        }

        return answer;
    }
}
