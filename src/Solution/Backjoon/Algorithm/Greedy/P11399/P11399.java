package Solution.Backjoon.Algorithm.Greedy.P11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11399 {
    static int N;
    static int[][] line;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Greedy/P11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N][1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int val = 0, total = 0;
        for (int i = 0; i < N; i++) {
            val += line[i][0];
            total += val;
        }
        System.out.println(total);
    }
}
