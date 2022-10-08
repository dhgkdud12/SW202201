package Solution.SWEA.D2.P1284;

import java.io.*;
import java.util.StringTokenizer;

public class P1284 {
    static int T, W, result;
    static int P; // A사
    static int Q, R, S; // B사 기본요금, 사용량 기준, 초과시 1리터당 가격
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1284/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // A사 가격
            int a = P*W;
            int b = 0;
            if (W > R) {
                b = Q + (W-R)*S;
            } else {
                b = Q;
            };

            if (a > b) result = b;
            else result = a;

            System.out.println("#"+(i+1)+" "+result);
        }
    }
}
