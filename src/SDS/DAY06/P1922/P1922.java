package SDS.DAY06.P1922;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1922 {
    static int N, M, a, b, c;
    static int[] parent;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/SDS.DAY06/P1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; // c 오름차순 정렬
            }
        });

        parent = new int[N+1];
        initialize();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});
        }
        

        int total = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (find(tmp[0]) != find(tmp[1])) { // 부모가 다르다면
                union(tmp[0], tmp[1]);
                total += tmp[2];
//                System.out.println(tmp[0] +" " + tmp[1]);
//                System.out.println("c" + tmp[2]);
            }
        }
//        for (int a : parent) {
//            System.out.println(a);
//        }
        System.out.println(total);
    }

    // 초기화
    public static void initialize() {
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
    }

    // Union 연산
    public static void union(int a, int b) { // a를 b에 합침
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    // Find 연산
    public static int find(int a) {  // 루트노드 반환
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

}
