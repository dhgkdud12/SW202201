package Solution.Programmers.Sort;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {6,6,6,6,6,1};
        H_Index h = new H_Index();
        System.out.println(h.solution(citations));
    }
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                System.out.println(i);
                answer = h;
                break;
            }
        }
        return answer;
    }
}
