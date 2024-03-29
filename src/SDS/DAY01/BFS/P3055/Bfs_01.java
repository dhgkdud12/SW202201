package SDS.DAY01.BFS.P3055;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_01 {

    //                      좌, 우, 위, 아래
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};

    static int R, C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean foundAnswer;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SDS.DAY01/Dfs/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt(); // 3
        C = sc.nextInt(); // 3

        map = new char[R][C];
        dp = new int[R][C]; // map이랑 크기가 같아야함.
        queue = new LinkedList<>(); //queue는 자바에서 linkedList를 사용

        Point st = null;
        int dx = 0, dy = 0;
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == '*') { // * : 물에 차있는 지역
                    queue.add(new Point(r,c,'*'));
                } else if (map[r][c] == 'S') { // 바로 넣으면 안됨, S : 고슴도치 위치
                    st = new Point(r, c, 'S'); //st에 저장
                } else if (map[r][c] == 'D') { // D : 비버의 굴
                    dy = r;
                    dx = c;
                }
            }
        }

        queue.add(st); // 마지막에 고슴도치 위치가 들어가게 됨

        // Q [*, S]
        int result = 0;

        while (!queue.isEmpty()) {
            //1. 큐에서 꺼내옴 -> *, S, ., D (돌은 방문조차 못하기때문에 큐에 못들어감)
            Point p = queue.poll(); // queue에서 꺼낸 p
            //2. 목적지인가? -> D
            if (p.type == 'D') { // 목적지로 가야하는 비버의 굴이라면
                foundAnswer = true;
                break;
            }
            //3. 연결된 곳을 순회 -> 좌우위아래 다 확인
            for (int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                //4. 갈 수 있는가? (공통) : 맵 안에 들어오는가
                if (0 <= ty && ty < R && 0<= tx && tx < C) { // 0 <= ty <= R, 0<= tx <= C
                    if (p.type == 'S' || p.type == '.') { // 큐에서 꺼낸 값의 type이 S거나 .이라면
                        //4. 갈 수 있는가? (고슴도치) : . or D, 방문하지 않은 곳
                        if ((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) { // 상하좌우 값에 해당하는 문자가
                            //5. 체크인 ( 고슴도치 ) : dp[][] = 이동거리
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                    } else if (p.type == '*'){
                        //4. 갈 수 있는가? (물) : ., S
                        if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            //5. 체크인 ( 물 ) : map[][] = *
                            map[ty][tx] = '*';
                            //6. 큐에 넣음
                            queue.add(new Point(ty, tx,'*'));
                        }

                    }
                } else foundAnswer = false;
            }
        }
        if(foundAnswer) {
            System.out.println(dp[dy][dx]);
        } else {
            System.out.println("KAKTUS");
        }
    }
}
    class  Point { // queue에 넣을 객체
    int y;
    int x;
    char type;

    public Point(int y, int x, char type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
