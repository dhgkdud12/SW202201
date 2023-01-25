package SDS.DAY01.P1713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int N, K;

    static Nominee[] nominees;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/SDS.DAY01/P1713/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 사진틀의 개수
        K = sc.nextInt(); // 전체 학생의 총 추천 횟수

        nominees = new Nominee[K+1];
        List<Nominee> list = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt();
            // 해당 후보가 최초 호출시
            if (nominees[num] == null) {
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            // 해당 후보가 사진들이 있을 경우
            if (nominees[num].isIn == true) {
                nominees[num].count++; // 추천횟수 증가
            } else {
                // 해당 후보가 가득 찬 경우
                if (list.size() == N) {
                    // 정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    Nominee nominee = list.remove(0); // 추천횟수 가장 적은 학생사진 삭제
                    nominee.isIn = false;
                }
                // 사진들에 여유가 있는 경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = k;
                list.add(nominees[num]);
            }

        }
        // 학생 번호 오름차순 정렬
        Collections.sort(list, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for (Nominee n : list) {
            System.out.print(n.num + " ");
        }
    }
}

class Nominee implements Comparable<Nominee>{
    int num;
    int count;
    int timeStamp;
    boolean isIn; // 사진 여부

    public Nominee(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    // 1. 추천수, 2. 시간
    @Override
    public int compareTo(Nominee o) {
        int comp = Integer.compare(count, o.count); 
        if (comp == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp;
        }
    }
}