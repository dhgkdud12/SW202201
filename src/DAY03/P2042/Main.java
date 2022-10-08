package DAY03.P2042;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, S;
    static int[] nums, tree;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N+1];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }

        tree = new int[2*S];
        initialize();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if (a==1) {
                long diff =  c - tree[S + b - 1];
                update(1, S, 1, b, diff);
                System.out.println(Arrays.toString(tree));
            } else {
                sb.append(query(1, S, 1, b, (int) c) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();


    }

    static void initialize() {
        // leaf 노드
        for (int i = 0; i < N; i++) {
            tree[S+i] = nums[i];
        }

        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i*2] + tree[i*2 + 1];
        }

        System.out.println(Arrays.toString(tree));
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || target > right) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) { // 내부노드
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid+1, right, node * 2 + 1, target, diff);
            } else if (left == right){ // leaf 노드
                nums[target] = tree[node];
                return;
            }
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryRight < left || queryLeft > right) {
            return 0;
        }
        else if (queryLeft <= left && queryRight >= right) {
            return tree[node];
        } else {
            int mid = ( left + right) / 2;
            long resultLeft = query(left, mid, node*2,queryLeft, queryRight );
            long resultRight = query(mid+1, right, node*2+1, queryLeft,queryRight);
            return resultLeft+resultRight;
        }
    }
}
