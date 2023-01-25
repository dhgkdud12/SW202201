package Solution.Programmers.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class BigNumber {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String answer = "";

        for (String s : str) {
            answer += s;
        }

        System.out.println(answer);
    }
}
