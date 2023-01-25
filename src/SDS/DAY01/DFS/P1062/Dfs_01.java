package SDS.DAY01.DFS.P1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//1062
public class Dfs_01 {
    static int N, K;
    static String[] words;
    static boolean[] visited = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SDS.DAY01/Dfs/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

//        System.out.println(N + ", " + K);

        sc.nextLine();
        words = new String[N];

        for (int i=0; i<N; i++) {
            String str = sc.nextLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        visited['a' - 97] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;
        visited['i' - 97] = true;
        visited['c' - 97] = true;

        dfs(0,0);
        System.out.println(max);
//        System.out.println(Arrays.toString(words));
        
    }
    static void dfs(int depth, int alpha) {
        //1. 체크인
        //2. 목적지인가? 깊이 == k
       if (depth + 5 == K) {
           int count = 0;
           for (int i = 0; i < N; i++) {
               boolean isValue = true;
               for (int j = 0; j < words[i].length(); j++) {
                   if (!visited[words[i].charAt(j) - 'a']) {
                       isValue = false;
                       break;
                   }
               }
               if (isValue) {
                   count++;
               }
           }
           max = Math.max(count, max);
           return;
       }
        //3. 연결된 곳을 순회
        for (int i = alpha; i < 26; i++) {
            //4. 갈 수 있는가?
            if (!visited[i]) {
                visited[i] = true;
                //5. 간다
                dfs(depth+1, i+1);
                //6. 체크아웃
                visited[i] = false;
            }

        }

    }
}

//1. 체크인
//2. 목적지인가?
//3. 연결된 곳을 순회
    //4. 갈 수 있는가?
        //5. 간다
//6. 체크아웃


