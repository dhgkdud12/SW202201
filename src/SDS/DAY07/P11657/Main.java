package SDS.DAY07.P11657;

import java.io.*;
import java.util.*;

// 타임머신
// 벨만-포드-무어 알고리즘
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken()); // 도시 개수
        int M = Integer.parseInt(tk.nextToken()); // 버스 노선의 개수

        long[] D = new long[N+1]; // 정점
        int[][] edgeList = new int[M][3]; // 간선
        long INF = Long.MAX_VALUE;
        
        for(int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            edgeList[i][0] = Integer.parseInt(tk.nextToken()); // 시작도시
            edgeList[i][1] = Integer.parseInt(tk.nextToken()); // 도착도시
            edgeList[i][2] = Integer.parseInt(tk.nextToken()); // 버스 이동 시간
        }
        Arrays.fill(D, INF);
        D[1] = 0; // 1번 도시
        int a, b, w;
        boolean flag = false;
        for(int i = 1; i <= N; i++) { // 3
            for(int j = 0; j < M; j++) {
                a = edgeList[j][0];
                b = edgeList[j][1];
                w = edgeList[j][2];
                if(D[a] == INF) continue;
                if(D[b] > D[a] + w) { // w가 음수라면
                    if(i == N) flag = true; // V-1까지 계산, V일 때 갱신되면 음수 간선 순환임
                    D[b] = D[a] + w; // 최단경로
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if(flag) sb.append(-1); // 시간 무한히 오래 전으로 되돌릴 수 있음(음수 간선 순환)
        else {
            for(int i = 2; i <= N; i++) { 
                sb.append((D[i] == INF ? -1 : D[i]) + "\n"); 
            }
        }
        System.out.print(sb);

    }
}
