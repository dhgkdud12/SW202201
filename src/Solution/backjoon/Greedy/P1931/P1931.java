package Solution.backjoon.Greedy.P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {
    static int N, count;
    static StringTokenizer st;
    static int[][] time;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) // 종료시간 같을 경우 시작시간 빠른순 
                     return o1[0] - o2[0];
                return o1[1] - o2[1]; // 종료시간 빠른순
            }
        });

        int e_time = 0;
        for (int i = 0; i < N; i++) {
            if (e_time <= time[i][0]) {
                System.out.println(time[i][0] + " " + time[i][1]);
                e_time = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
