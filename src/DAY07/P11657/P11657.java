package DAY07.P11657;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bus{
    // 시작점, 도착점, 걸리는 시간
    int start, end, weight;

    public Bus(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
public class P11657 {
    private static final int INF = 500 * 100_000;
    static int N, M, A, B, C;
    static int dist[];
    static Bus busArr[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY07/P11657/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        busArr = new Bus[M+1];
        dist = new int[N+1];
        // 최단거리 배열 무한대로 초기화
        for (int i = 1; i < N; i++) {
            dist[i] = dist[i] = INF;
        }

        // 입력값 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken()); // 시작도시
            B = Integer.parseInt(st.nextToken()); // 도착도시
            C = Integer.parseInt(st.nextToken()); // 이동시간

            busArr[i] = new Bus(A, B, C);
        }

        // 결과 출력을 위한 객체
        StringBuilder sb = new StringBuilder();

        // 음의 cycle이 없는 경우
        if (bellmanFord()) {
            for (int i = 2; i <= N ; i++) {
                sb.append(dist[i] == INF ? "-1\n" : dist[i] + "\n");
            }
            //  음의 cycle이 있는 경우
        } else {
            sb.append("-1\n");
        }

        System.out.println(sb);

    }

    // 음의 cycle이 있다면 false 리턴, 없다면 true 리턴
    // 벨만포드 알고리즘
    private static boolean bellmanFord() {
        // 시작점 최단거리 0 갱신
        dist[1] = 0;

        // v-1번 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Bus bus = busArr[j];
                // 더 작은 최단거리가 있는 경우 갱신
                if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.weight) {
                    dist[bus.end] = dist[bus.start] + bus.weight;
                }
            }
        }

        // 음수 cycle 확인
        // 갱신되는게 있다면 음수 cycle이 있다는 뜻
        for (int i = 0; i < M; i++) {
            Bus bus = busArr[i];

            if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.weight)
                return false;
        }
        return true;
    }
}
