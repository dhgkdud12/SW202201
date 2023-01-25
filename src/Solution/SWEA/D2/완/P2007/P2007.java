package Solution.SWEA.D2.완.P2007;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 앞 두 글자 추출
public class P2007 {
    static int T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Solution/SWEA/D2/P2007/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            for (int j = 10; j >= 1; j--) {
                int len = check(10, str); // 10글자 같을 경우
                if (len == 10) {
                    int relen = check(5, str); // 5글자 같을 경우
                    if (relen != -1) {
                        if (check(1,str) != -1) { // 1글자 같을 경우
                            print(i, 1);
                            break;
                        }
                        else {
                            print(i, relen);
                            break;
                        }
                    } else {
                        print(i, len);
                        break;
                    }
                } else {
                    print(i, len);
                    break;
                }
            }
        }
    }

    static public int check(int i, String str) {
        if (i == 5) {
            String pre = str.substring(0,5);
            String next = str.substring(5, 10);
            if (pre.equals(next)) {
                return pre.length();
            }
        } else if (i == 1) {
            String pre = str.substring(0,1); //KKKKK
            String next = str.substring(2,3);
            String pre2 = str.substring(0,3); //ABABCABABC
            String next2 = str.substring(4,6);
            if (pre.equals(next) && pre2.equals(next2)) {
                return pre.length();
            }
        }
        else {
            for (int j = i; j >= 1; j--) {
                String pre = str.substring(0,j);
                String next = str.substring(j, j+j);
                if (pre.equals(next)) {
//                    System.out.println(pre);
//                    System.out.println(next);
                    return pre.length();
                }
            }
        }
        return -1;
    }

    static public void print(int i, int len) {
        System.out.println("#"+(i+1)+ " " + len);
    }
}
