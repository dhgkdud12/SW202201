package Solution.SWEA.D2.완.P1983;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1983 {
    static String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    static int T, N, K;
    static Student[] stdArray;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P1983/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            stdArray = new Student[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                stdArray[j] = new Student(j+1, calc(a,b,c));
            }

            Arrays.sort(stdArray, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o2.total, o1.total);
                }
            });

            for (int j = 0; j < N; j++) {
                System.out.println(stdArray[j].total);
                if (K == stdArray[j].id) {
//                    System.out.println("#"+(i+1)+" "+grades[j/(N/10)]);
                    break;
                }
            }
        }
    }

    static public double calc(int a, int b, int c) {
        double result = (int)((0.35*a) + (0.45*b) + (0.20*c));
        return result;
    }

    static public class Student {
        int id;
        double total;

        Student(int id, double total) {
            this.id = id;
            this.total = total;
        }

    }
}
