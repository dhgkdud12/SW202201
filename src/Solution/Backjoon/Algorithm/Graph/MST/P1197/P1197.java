package Solution.Backjoon.Algorithm.Graph.MST.P1197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197 {
    static int V, E, a, b, c;
    static int[] parent;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph//P1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; // 가중치 오름차순 정렬
            }
        });
        
        parent = new int[V+1];
        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a,b,c});
        }

        int total = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (find(tmp[0]) != find(tmp[1])) {// 부모가 다르다면
                union(tmp[0], tmp[1]);// union 연산
                total += tmp[2];
            }
        }

        System.out.println(total);
        
    }
    
    // 초기화
    static public void init() {
        for (int i = 1; i <= V ; i++) {
            parent[i] = i;
        }
    }

    // Union 연산
    static public void union(int a, int b) { // b에 a를 합침
        parent[find(a)] = find(b);
    }

    // Find 연산
    static public int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]); // 재귀
    }

}
