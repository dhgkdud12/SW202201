package SDS.DAY01.DFS.P1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dfs_01_pro {
    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int selectedCount = 0;
    static int max = 0;

    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(fib(4));

        System.setIn(new FileInputStream("src/SDS.DAY01/Dfs/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        words = new String[N];
        visited = new boolean[26];

        visited['a' - 'a'] = true;
        visited['n' - 'n'] = true;
        visited['t' - 't'] = true;
        visited['i' - 'i'] = true;
        visited['c' - 'c'] = true;

        for (int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]", ""); // 정규식
        }

        selectedCount = 5;

        if (K<5) {
            System.out.println(0);
        } else if (K==26) {
            System.out.println(N);
        } else {
            max = countWords();

            for (int i = 0; i < 26; i++) {
                if (visited[i] == false) {
                    dfs(i);
                }
            }
            System.out.println(max);
        }
    }
    
    static void dfs(int index) {
        // 1. 체크인
        visited[index] = true;
        selectedCount++;
        // 2. 목적지인가? : seletedCount == K => 읽을 수 있는 단어 계산
        if (selectedCount == K) {
            max = Math.max(max, countWords());
        } else {
            // 3. 연결된 곳을 순회 : index + 1 ~ 25
            for (int i = index+1; i <= 25 ; i++) {
                // 4. 갈 수 있는가? : 방문 여부
                if (visited[i] == false)
                    // 5. 간다 : dfs
                    dfs(i);
            }
        }

        // 6. 체크아웃
        visited[index] = false;
        selectedCount--;

    }

    static int countWords() {
        int count = 0;
        for (int n = 0; n < N; n++) {
           boolean isPossible = true;
           String word = words[n];
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) count++;
        }
        return count;
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
