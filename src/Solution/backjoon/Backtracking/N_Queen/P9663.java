package Solution.backjoon.Backtracking.N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int N, count;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N]; // idx - 열, 원소 값 - 행
        nqueen(0);
        System.out.println(count);
    }

    static public void nqueen(int n) {
        if (n == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[n] = i;
            if (promising(n)) {
                nqueen(n+1); // 다음 행
            }
        }
    }

    static public boolean promising(int n) { // 유망한지 판단
        for (int i = 0; i < n; i++) {
            if (board[n] == board[i] || Math.abs(n-i) == Math.abs(board[n] - board[i])) // 같은 열이거나 대각선에 있으면 안됨
                return false;
        }
        return true;
    }
}
