//package SDS.DAY01.DFS;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//1759
//public class Dfs_02 {
//    static int L, C;
//    static char[] data;
//    static LinkedList result;
//    static boolean[] visited;
//    static String[] code;
//
//    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("src/SDS.DAY01/Dfs/input.txt"));
//        Scanner sc = new Scanner(System.in);
//
//        L = sc.nextInt();
//        C = sc.nextInt();
//
//        System.out.println(L + ", " + C);
//
//        data = new char[C];
//        for (int i = 0; i < C; i++) {
//            data[i] = sc.next().charAt(0);
//        }
//
//        Arrays.sort(chars);
//
//        visited = new boolean[26];
//
//    }
//    static void dfs(int length, int ja, int mo, int current, String pws) {
//        //1. 체크인
//        visited[index] = true;
//        selectedCount++;
//        //2. 목적지인가? depth == L
//        if(selectedCount == L) {
//            return;
//        } else {
//            //3. 연결된 곳을 순회
//            for (int i = index+1; i < chars.length; i++) {
//                //4. 갈 수 있는가?
//                if (visited[i] == false) {
//                    //5. 간다
//                    dfs(i);
//                }
//            }
//        }
//
//        //6. 체크아웃
//        selectedCount--;
//        visited[index] = false;
//
//    }
//}
//
////1. 체크인
////2. 목적지인가?
////3. 연결된 곳을 순회
//    //4. 갈 수 있는가?
//        //5. 간다
////6. 체크아웃
//
//
