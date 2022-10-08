package DAY03.P1202;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보석
        K = Integer.parseInt(st.nextToken()); // 가방

        Jewelry[] jewelries = new Jewelry[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(m,v);
        }
        // 무게, 가격 순으로 정렬
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.weight == o2.weight) {
                    return o2.value - o1.value; // 내림차순
                }
                return o1.weight - o2.weight; // 오름차순
            }
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        int j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int result = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);


    }
}
