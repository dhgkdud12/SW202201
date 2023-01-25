package Solution.Backjoon.Step.P1193;

import java.util.Scanner;

public class P1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int crossCnt = 1;
        int preCntSum = 0;

        while (true) {
            
            // 직전 대각선 누적합 + 해당 대각선 개수 이용 범위 판별
            if (input <= preCntSum + crossCnt) {

                if (crossCnt % 2 == 1) { // T의 개수가 홀수라면
                    // 분자가 큰 수부터 시작
                    // 분자 = 대각선상 블록 개수 - (X번째 - 직전 대각선까지의 블럭 개수 -1)
                    // 분모 = input번째 - 직전 대각선까지의 블록 개수

                    System.out.println((crossCnt - (input - preCntSum - 1)) + "/" + (input - preCntSum));
                    break;

                } else { // T의 개수 짝수라면

                    // 홀수일 때 출력 반대로
                    System.out.println((input - preCntSum) + "/" + (crossCnt - (input - preCntSum - 1)));
                    break;
                }
            } else {
                preCntSum += crossCnt;
                crossCnt++;
            }

        }
    }
}
