package Solution.SWEA.D2.P1984;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1984 {
    static int N;
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1984/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            double result = avg(arr);
            System.out.println("#"+(i+1)+" "+Math.round(result));
        }
    }

    public static double avg(int[] arr) {
        double result = 0;
        for (int i = 1; i < 9 ; i++) {
            result+= arr[i];
        }
        return result/8;
    }
}
