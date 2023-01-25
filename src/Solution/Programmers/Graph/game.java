package Solution.Programmers.Graph;

import java.util.LinkedList;
import java.util.Queue;

// 매개변수인 maps에 그대로 하면 안됨
public class game {
    public static int[][] maps;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n,m;
    public static int[][] visited;
    public static void main(String[] args) {
        maps = new int[][]
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                };
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        bfs(0,0);
        visited[0][0] = 1;
        if (visited[n-1][m-1] == 0) System.out.println(-1);
        else System.out.println(visited[n-1][m-1]+1);

    }
    static public void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        while (!q.isEmpty()) {
            int now[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (visited[nx][ny] != 0 || maps[nx][ny] == 0) continue;
                q.offer(new int[]{nx,ny});
                visited[nx][ny] = visited[now[0]][now[1]] + 1;
            }
        }
    }

}

