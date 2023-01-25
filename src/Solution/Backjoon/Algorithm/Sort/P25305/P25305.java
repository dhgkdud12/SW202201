package Solution.Backjoon.Algorithm.Sort.P25305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25305 {
    static int N, K;
    static int[] students;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Sort/P25305/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        students = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        System.out.println(students[students.length-K]);
    }
}
