package Solution.backjoon.Graph.MST.P4386;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4386 {
    static int n;
    static Star[] star;
    static int[] parent;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Graph/MST/P4386/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        star = new Star[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star[i] = new Star(x,y);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.w, o2.w);
            }
        });

        init();

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                pq.add(new Edge(i,j,distance(i,j)));
            }
        }

        double result = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.u) != find(cur.v)) {
                union(cur.u, cur.v);
                result += cur.w;
            }
        }

        System.out.println(Math.round(result*100)/100.0); // 소수점 두번째자리

    }

    // 거리 계산
    static public double distance(int a, int b) {
        double distance = Math.sqrt((Math.pow(star[a].x - star[b].x, 2) + Math.pow(star[a].y - star[b].y, 2)));
        return distance;
    }
    static public void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static public void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    static public int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static public class Star{
        double x, y;

        Star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static public class Edge{
        int u, v;
        double w;

        Edge(int u, int v, double w){
            this. u = u;
            this.v = v;
            this.w = w;
        }
    }
}
