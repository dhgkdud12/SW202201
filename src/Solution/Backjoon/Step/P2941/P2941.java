package Solution.Backjoon.Step.P2941;

import java.util.Scanner;

public class P2941 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int cnt = 0;
        int len = input.length();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == 'c') {
                if( i < len - 1) {
                    char nch = input.charAt(i+1);
                    if ((nch == '=') || (nch == '-')) {
                        i++;
                    }
                }
            }

            if (ch == 'd') {
                if (i < len - 1) {
                    char nch = input.charAt(i+1);
                    if (nch == 'z') {
                        if (i < len -2 ) {
                            if (input.charAt(i+2) == '=') {
                                i += 2;
                            }
                        }
                    } else if (nch == '-') {
                        i++;
                    }
                }
            }

            if (ch == 'l') {
                if (i < len - 1) {
                    if (input.charAt(i+1) == 'j') {
                        i++;
                    }
                }
            }

            if (ch == 'n') {
                if (i < len - 1) {
                    if (input.charAt(i+1) == 'j') {
                        i++;
                    }
                }
            }

            if (ch == 's') {
                if (i < len - 1) {
                    if (input.charAt(i+1) == '=') {
                        i++;
                    }
                }
            }

            if (ch == 'z') {
                if (i < len - 1) {
                    if (input.charAt(i+1) == '=') {
                        i++;
                    }
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
