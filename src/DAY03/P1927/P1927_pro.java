package DAY03.P1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1927_pro {
    static int N;
    static int X;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/DAY03/P1927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinHeap mh = new MinHeap();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            if (X == 0) {
                if (mh.list.size() <= 1) {
                    System.out.println(0);
                } else {
                    System.out.println(mh.delete(i));
                }
            } else {
                mh.insert(X);
            }
        }
    }
}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        // 1. leaf 마지막에 삽입
        list.add(val);
        // 2. 부모와 비교 후 조건에 맞지 않으면 Swqp
        // 3. 조건이 만족되거나 roof 까지 반복
        int current = list.size() - 1;
        int parent = current / 2;
        while (true) {
            if (parent == 0 || list.get(parent) <= list.get(current)) {
                break;
            }

            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete(int val) {
        if (list.size() == 1) {
            return 0;
        }
        // 1. Roof 에 leaf 마지막 데이터 가져옴
        int top = list.get(1);
        list.set(1, list.get(list.size()-1));
        list.remove(list.size()-1);

        // 2. 자식과 비교 후 조건에 맞지 않으면 Swqp
        // 3. 조건이 만족되거나 leaf 까지 반복
        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;
            // 왼쪽 자식 먼저 확인
            if (leftPos >= list.size()) { // list 경계 벗어남, 왼쪽 자식 없음
                break;
            }
            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 자식 확인
            if (rightPos < list.size() && minValue > list.get(rightPos)) { // 오른쪽 자식노드가 왼쪽 자식노드보다 작을 경우
                minValue = list.get(rightPos);
                minPos = rightPos;
            }

            // swap
            if (list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos, temp);
                currentPos = minPos;
            } else {
                break;
            }
        }
        return top;
    }

}
