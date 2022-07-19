package DAY01.DFS.P1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Dfs_02_pro {
    static int L, C;
    static char[] data;
    static List<String> result;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/DAY01/Dfs/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        System.out.println(L + ", " + C);

        data = new char[C];
        result = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);

        dfs(0, 0, 0, -1, "");

        for (String s : result) {
            System.out.println(s);
        }

    }
    static void dfs(int length, int ja, int mo, int current, String pwd) {
        //1. 체크인 - 생략 가능
        //2. 목적지인가? : length == L => ja 개수, mo 개수 확인 암호 가능 판별
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        } else {
            //3. 연결된 곳을 순회 : current + 1 ~ C
            for (int i = current + 1; i < C; i++) {
                //4. 갈 수 있는가? : 다 갈 수 있음
                //5. 간다 -> ja, mo
                if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u')
                    dfs(length+1, ja, mo+1, i, pwd + data[i]);
                else
                    dfs(length+1, ja+1, mo, i, pwd + data[i]);
            }
        }
        //6. 체크아웃 - 생략 가능

    }
}

//1. 체크인
//2. 목적지인가?
//3. 연결된 곳을 순회
    //4. 갈 수 있는가?
        //5. 간다
//6. 체크아웃


