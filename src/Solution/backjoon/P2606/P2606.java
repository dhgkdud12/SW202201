package Solution.backjoon.P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
    static int N, M, count;
    static ArrayList<Integer>[] computers;
    static boolean[] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computers = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N ; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            computers[u].add(v);
            computers[v].add(u);
        }

        visited[1] = true;
        bfs(1);
        System.out.println(count-1);
    }

    static public void bfs (int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int now = q.poll();
            count++;
            for (int i = 0; i < computers[now].size(); i++) {
                int next = computers[now].get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

    }
}
