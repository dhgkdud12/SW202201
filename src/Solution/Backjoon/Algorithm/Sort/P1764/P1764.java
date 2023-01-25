package Solution.Backjoon.Algorithm.Sort.P1764;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1764 {
    static StringTokenizer st;
    static int N, M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/backjoon/Sort/P1764/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < N+M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                arrayList.add(name);
            } else {
                set.add(name);
            }
        }

        Collections.sort(arrayList);

        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
