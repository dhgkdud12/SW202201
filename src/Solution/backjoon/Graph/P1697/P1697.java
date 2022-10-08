package Solution.backjoon.Graph.P1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    static int N, K;
    static StringTokenizer st;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph//P1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001]; // 범위 0 ~ 100,000

        if (N==K) System.out.println(0);
        else {
            bfs(N);
            System.out.println(visited[K]);
        }
//        System.out.println(Arrays.toString(visited));
    }

    static public void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visited[num] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if(visited[K] != 0) {
                break;
            }
            if (x-1 >= 0 && visited[x-1] == 0) { // X-1
                visited[x-1] = visited[x]+1;
                q.offer(x-1);
            }

            if (x+1 <= 100000 && visited[x+1] == 0) { // X+1
                visited[x+1] = visited[x]+1;
                q.offer(x+1);
            }

            if (2*x <= 100000 && visited[2*x] == 0) { // 2*X
                visited[2*x] = visited[x]+1;
                q.offer(2*x);
            }
        }
    }
}
