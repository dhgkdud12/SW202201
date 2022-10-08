package Solution.backjoon.P2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2667 {
    static int N, count;
    static int[] aparts = new int[1001];
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/P2667/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
//                    System.out.println(i +" " + j);
                    bfs(i, j);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(graph[i][j]);
//            }
//            System.out.println();
//        }

        Arrays.sort(aparts);

        System.out.println(count);
//        System.out.println(Arrays.toString(aparts));
        for (int i = 0; i < aparts.length ; i++) {
            if (aparts[i] != 0) {
                System.out.println(aparts[i]);
            }
        }

    }

    static public void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
//        graph[x][y] = ++count;
        aparts[++count]++;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (graph[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                q.offer(new int[]{nextX, nextY});
//                graph[nextX][nextY] = count;
                aparts[count]++;
                visited[nextX][nextY] = true;
            }
        }
    }
}
