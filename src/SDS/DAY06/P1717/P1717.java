package SDS.DAY06.P1717;

import java.io.*;
import java.util.StringTokenizer;

//+17398
// 유니온 파인드, 서로소 집합
public class P1717 {
    static int N, M, q, a, b;
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SDS.DAY06/P1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        depth = new int[N+1];

        initialize();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            q = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (q == 0) {
                union(a, b);
            } else if (q == 1) {
                if (check(a, b)) bw.append("YES\n");
                else bw.append("NO\n");
            }
        }

        bw.flush();
    }

    // 초기화
    public static void initialize() {
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
    }

    // Union 연산
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if ( aRoot != bRoot) {
            if (depth[aRoot] < depth[bRoot]) { // 최적화
                int tmp = aRoot;
                aRoot = bRoot;
                bRoot = tmp;
            }
            parent[aRoot] = bRoot;
            if (depth[aRoot] == depth[bRoot]) depth[aRoot]++;
        }
    }

    // Find 연산
    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static boolean check (int a, int b) {
        if (find(parent[a]) == find(parent[b])) return true;
        else return false;
    }
}
