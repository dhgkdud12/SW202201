package DAY05.P1837;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 질문 복사
public class P1837 {
    static String P;
    static int K;
    static boolean[] isNotPrime;
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY05/P1837/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken(); // 암호
        K = Integer.parseInt(st.nextToken()); // K
        isNotPrime = new boolean[K+1];
        primes = new ArrayList<>();

        for (int i = 2; i <= K; i++) { // 10
            if (!isNotPrime[i]) {
                primes.add(i); // 소수 저장, 2 3 5 7
                for (int j = i * 2; j <= K; j += i) {
                    isNotPrime[j] = true; // 소수 아님
                }
            }
        }

        for (int prime : primes) {
            if (prime >= K) {
                break;
            }
            if (check(prime)) {
                System.out.println("BAD " + prime); // prime : 암호를 이루는 두 소수 중 작은 소수
                return;
            }
        }
        System.out.println("GOOD");
    }

    static public boolean check(int x) {
        int pre = 0;
        for (int j = 0; j < P.length(); j++) {
            pre = (pre * 10 + (P.charAt(j) - '0')) % x; // 143
            System.out.println("pre x " + pre + " " + x);
        }
        if (pre == 0) {
            return true;
        } else {
            return false;
        }
    }
}