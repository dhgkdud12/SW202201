package DAY03.P1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202_pro {
    static int N, K;

    static Jewelry[] jewelries;
    public static void main(String[] args) throws IOException {

        int[] bags;

        System.setIn(new FileInputStream("src/DAY03/P1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보석
        K = Integer.parseInt(st.nextToken()); // 가방

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 오름차순 정렬
        Arrays.sort(bags);
        // 보석 무게 오름차순 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        // 보석 가격이 높은 값 기준 힙
        PriorityQueue<Jewelry> pq = new PriorityQueue<Jewelry>(Comparator.comparingInt(Jewelry::getValue).reversed());

        // 투포인터 + pq

        int jIndex = 0; // 포인터 1
        long result = 0;
        // 1. 남은 가방 중 제일 작은 가방을 선택. <- 정렬
        for (int i=0; i<bags.length; i++) { // 포인터 2
            // 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택. <- 힙을 사용.
            while (jIndex < N && jewelries[jIndex].weight <= bags[i] ) {
                System.out.println(jewelries[jIndex].value);
                pq.add(jewelries[jIndex++]); // 65, 99, 65
            }
            if (!pq.isEmpty()) {
                result += pq.poll().value;
            }

        }
        System.out.println(result);


    }
}

class Jewelry {
    int weight; //무게
    int value; //가격

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public Jewelry(int mass, int value) {
        this.weight = mass;
        this.value = value;
    }
}