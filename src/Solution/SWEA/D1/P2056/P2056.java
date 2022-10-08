package Solution.SWEA.D1.P2056;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2056 {
    static int t;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D1/P2056/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            arr = new int[8];
            for (int j = 0; j < 8; j++) {
                arr[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }

            if (arr[4] == 0 && arr[5] == 0) System.out.printf("#%d %d\n", (i+1), -1);
            else if ((arr[4]==0 && arr[5]==2) && (arr[6] >= 3 || (arr[6] ==2 && arr[7] > 9))) System.out.printf("#%d %d\n", (i+1), -1);
            else System.out.printf("#%d %d%d%d%d/%d%d/%d%d\n", (i+1), arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
        }

    }

}
