package SDS.DAY03.P2042;

import java.io.*;
import java.util.StringTokenizer;

public class P2042 {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SDS.DAY03/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N+1];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine()); // 배열 값
        }

        S = 1;
        while (S < N) {
            S *= 2; // 2, 4, 8, S = 8
        }
        tree = new long[S * 2]; // 총 노드 개수 2 * S - 1, index 1부터

        initBU();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); // 인덱스
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - tree[S + b -1]; // 차이, 6-3
                // nums[b-1]로 할 경우 nums[0]이면 문제있음
//                long diff = 0;
//                if (b==1) {
//                    diff = c - nums[b];
//                    nums[b] = c;
//
//                } else {
//                    diff  = c - nums[b-1];
//                    nums[b-1] = c;
//                }

//                System.out.println(diff);
//                System.out.println("nums[b] : " + nums[b]); // 3, 5
//                System.out.println("nums[b-1] : " + nums[b-1]);
//                nums[b] = c; // b번째 값 c로 변경
                update(1, S, 1, b, diff);
            } else if (a == 2) {
                sb.append(query(1, S, 1, b, (int) c) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // S 개념 중요
    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i]; // tree[8] 부터 1, 2, 3, 4, 5
        }
        // 내부노드 채움
        for (int i =  S - 1; i > 0 ; i--) { // 리프노드를 자식으로 갖는 노드부터 채움, 루트노트 마지막
            tree[i] = tree[i*2] + tree[i*2+1]; // 15, 10, 5, 3, 7, 5, 0
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        // 연관이 없음 -> 결과에 영향이 없는 값 return
        if (queryRight < left || right < queryLeft) {
            return 0;
        }
        // 판단 가능 -> 현재 노드 값 return
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 판단불가, 자식에게 위임, 자식에게 올라온 합을 return
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node *  2, queryLeft, queryRight); // 왼쪽 자식
            long resultRight = query(mid+1, right, node * 2 + 1, queryLeft, queryRight); // 오른쪽 자식
            System.out.println(queryLeft);
            System.out.print("resultLeft " + resultLeft);
            System.out.println(" resultRight " + resultRight);
            return resultLeft + resultRight;
        }
    }


    static void update(int left, int right, int node, int target, long diff) {
        // 연관없음
        if (target < left || right < target) {
            return;
        }
        // 연관있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
//            System.out.println("diff" + diff);
            tree[node] += diff; // 노드에 diff 반영
            if (left != right) {// leaf가 아니고 내부노드인 경우
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid+1, right, node * 2 + 1, target, diff);
            } else {
                nums[target] = tree[node];
                return;
            }
        }
    }

    //Bottom-up
    static long queryBU(int queryLeft, int queryRight) {
        // leaf 에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        long sum = 0;
        while (left <= right) { // left, right 뒤틀리기 전까지
            // 좌측 노드가 홀수이면 현재 노드 값 사용하고 한칸 옆으로
            if (left % 2 == 1) {
                sum += tree[left++];
            }
            // 우측 노드가 짝수이면 현재 노드 값 사용하고 한칸 옆으로
            if (right % 2 == 0) { // 오른쪽 경계가 왼쪽 자식에 걸림
                sum += tree[right--];
            }
            // 좌측, 우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        // Leaf에서 target을 찾음
        int node = S + target - 1;
        // value 반영
        tree[node] = value;
        // Root에 도달할 때까지 부모에 값 반영
        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}
