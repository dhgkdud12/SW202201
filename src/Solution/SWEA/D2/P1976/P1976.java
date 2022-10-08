package Solution.SWEA.D2.P1976;

import java.io.*;
import java.util.StringTokenizer;

public class P1976 {
    static int T;
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1976/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int hour = arr[0]+arr[2];
            int min = arr[1]+arr[3];
            if (min > 59) {
                hour++;
                min -= 60;
            }
            if (hour > 12) hour -= 12;

            System.out.println("#"+(i+1)+" "+hour+" "+min);
        }
    }
}
