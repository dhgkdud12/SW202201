package Solution.Backjoon.Algorithm.Graph.MST.P1647;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
도시를 2개로 분할
우지비의 합을 최소로 도시를 2개로 분할하려는 방법은 한 개의 도시로
만들 때 마지막 노드만 분리시키면 2개의 도시로 분할됨
 */

public class P1647 {
    static int N, M;
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph//P1647/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a,b,c});
        }

        init();



        int total = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (find(tmp[0]) != find(tmp[1])){ // 부모가 다르면
                union(tmp[0], tmp[1]);
                total += tmp[2];
                max = tmp[2];
                System.out.println("tmp[0] tmp[1] tmp[2] " + tmp[0] +" " + tmp[1] + " " + tmp[2]);
            }
        }
        sb.append(total - max);
        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();


    }

    static public void init() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static public void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    static public int find(int a) {
        if (parent[a] == a) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }
}
