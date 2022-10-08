package DAY03.P1927;

import java.io.*;
import java.util.PriorityQueue;

public class P1927 {
    static int N;
    static int X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P1927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            if (X == 0) {
                if (pq.isEmpty())
                    System.out.println(0);
                else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(X);
            }
        }
    }
}

