package DAY08.P3176;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P3176 {
    static int N, A, B, C, K ,D, E, h;
    static int[][] parent, minRoad, maxRoad;
    static int[] depth;
    static StringTokenizer st;
    static ArrayList<int[]>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY07/P3176/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];

        h = getTree();

        parent = new int[N+1][h];
        minRoad = new int[N+1][h];
        maxRoad = new int[N+1][h];

        boolean[] root = new boolean[N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            adj[A].add(new int[] {B, C});
            root[B] = true;
        }

        int rIdx = 0;
        for (int i = 1; i < N+1; i++) {
            if (root[i]) {
                rIdx = i;
                break;
            }
        }

        init(rIdx, 1, 0);
        fillParents();

        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

//            int[] res = LCA(D, E);
//            sb.append(res[0]+ " " + res[1]);
            if (i!=K) sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static int getTree() {
        return (int)Math.ceil(Math.log(N)/Math.log(2)) + 1;
    }

    static void fillParents() {
        for (int i = 1; i <h ; i++) {
            for (int j = 1; j < N+1; j++) {
                parent[j][j] = parent[parent[j][i-1]][i-1];
                maxRoad[j][i] = Math.max(maxRoad[j][i-1], maxRoad[parent[j][i-1]][i-1]);
                minRoad[j][i] = Math.min(minRoad[j][i-1], minRoad[parent[j][i-1]][i-1]);
            }
        }
    }
    static void init(int cur, int h, int pa) {
        depth[cur] = h;
        for (int[] next : adj[cur]) {
            if (next[0] != pa) {
                init(next[0], h+1, cur);
                minRoad[next[0]][0] = next[1];
                maxRoad[next[0]][0] = next[1];
                parent[next[0]][0] = cur;
            }
        }
    }
}
