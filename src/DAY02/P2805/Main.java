package DAY02.P2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY02/P2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);


        long start = 0;
        long end = tree[N-1];
        long mid = 0;
        while (true) {
            System.out.println("start"+start+"end"+end);
            mid = ( start + end ) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid ) {
                    total += (tree[i] - mid);
                }
            }
            System.out.println(mid);
            System.out.println(" "+total);
            if (total > M) { // M보다 크면 오른쪽
                start = mid + 1;
            } else if (total < M){ // M보다 작으면 왼쪽
                end = mid - 1;
            }
            else if (total == M ) {
                break;
            }

            if ( start > end && total >= M) break;
        }
        System.out.println(mid);
    }
}
