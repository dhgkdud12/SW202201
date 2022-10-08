package DAY02.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2143 {
    public static long T;
    public static int N, M;
    public static long[] inputA, inputB;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/DAY02/P2143/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());

        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        //subA 구하기
        for (int i = 0; i < N; i++) {
            long sum = inputA[i]; // 1, 3, 1, 2
            subA.add(sum);
            for (int j = i+1; j < N; j++) {
                sum += inputA[j]; // 1, 4, 5, 7, 3, 4, 5, 1, 3, 2
                subA.add(sum);
            }
        }
        //subB 구하기
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += inputB[j]; // 1, 4, 6, 3, 5, 2
                subB.add(sum);
            }
        }

        //subA, subB 정렬하기
        Collections.sort(subA);                            // 1, 1, 2, 3, 3, 4, 4, 5, 6, 7
        Collections.sort(subB, Comparator.reverseOrder()); // 6, 5, 4, 3, 2, 1

        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;
            //currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기, ptA+, ptb+
            if (subB.get(ptB) == target) {
                long countA = 0; // subA 같은 수 체크
                long countB = 0; // subB 같은 수 체크
                while (ptA < subA.size() && subA.get(ptA) == currentA) { 
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }

                result += countA * countB; // 곱해줌
            }
            //currentB > target -> ptB++
            else if (subB.get(ptB) > target) {
                ptB++;
            }
            //currentB < target -> ptA++
            else {
                ptA++;
            }

            //탈출 조건
            if (ptA == subA.size() || ptB == subB.size())
                break;

        }
        System.out.println(result);

    }
}
