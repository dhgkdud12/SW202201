package Solution.Backjoon.Algorithm.Sort.P18870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Sort/P18870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = arr.clone();

        Arrays.sort(arr);

        int cnt = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!hashMap.containsKey(arr[i])) { // 중복이 있을 수 있음, 순서 저장
                hashMap.put(arr[i], cnt++);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(hashMap.get(temp[i]) + " ");
        }

    }
}
