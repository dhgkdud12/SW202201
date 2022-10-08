package Solution.Programmers.Graph;

public class network {
    static int n = 3;
    static int[][] computers = { {1,1,0}, {1,1,1}, {0,1,1}};
    static boolean[] visited = new boolean[3];
    static int answer;
    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
                if (visited[i] == false) {
                    dfs(i);
                    answer++;
                }
        }
        System.out.println(answer);
    }

    static public void dfs (int i) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && visited[j] == false) { // 자기자신이 아니고 방문하지 않음
                visited[j] = true;
                dfs(j);
            }
        }

    }
}
