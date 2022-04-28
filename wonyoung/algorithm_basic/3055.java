package wonyoung.algorithm_basic;

import java.io.*;
import java.util.*;

class Main {
    static int R, C; // R이 몇 줄, C가 몇 번째 칸
    static char[][] map;
    static int[][] dp;
    static Queue<Pos> q = new LinkedList<>();

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    // 1. 큐에서 꺼내옴
    // 2. 목적지인가? D
    // 3. 연결된 곳을 순회 : 상하좌우 4가지 방향
    // 4.   갈 수 있는가? (1. 맵 영역 안, 2. .이고, 물이 인접하지 않는 곳[큐에 물을 먼저 넣으면 물이 인접한지 안한지 체크 안해도 됨], 3. 방문하지 않은 곳)
    // 5.       체크인 - 다른 배열 하나 더 만들기
    // 6.       큐에 넣음

    public static void main (String [] arg) throws Exception{
        // for coding
        System.setIn(new FileInputStream("./input/input_3055.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        dp = new int[R][C];

        Pos start = null;
        for (int i = 0; i < R; i++) {
            String currLine = br.readLine();
            for (int j = 0; j < C; j++) {
                char currChar = currLine.charAt(j);
                map[i][j] = currChar;
                if (currChar == 'S') start = new Pos('S',i,j);      // 출발
                else if (currChar == '*') q.add(new Pos('*', i, j));    // 물
                dp[i][j] = -1;
            }
        }
        q.add(start);

       while(true) {
           // 1. 큐에서 꺼내옴
           Pos currPos = q.poll();
           // 2. 목적지인가?
           if (currPos == null) {
               System.out.println("KAKTUS");
               break;
           }
           else if (map[currPos.row][currPos.col] == 'D') {
               System.out.println(dp[currPos.row][currPos.col] + 1);
               break;
           }

               // 3. 연결된 곳 순회
           else {
               //System.out.println("curr : " + currPos.type + currPos.row + " " + currPos.col);
               for (int i = 0; i < 4; i++) {
                   // 4.   갈 수 있는가? (맵 안에 있고, 물이 없고, 돌도 없는지)
                   int nextRow = currPos.row + dr[i];
                   int nextCol = currPos.col + dc[i];

                   if ( currPos.type == 'S' && nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C && map[nextRow][nextCol] != '*' && map[nextRow][nextCol] != 'X' && dp[nextRow][nextCol] == -1) {
                       dp[nextRow][nextCol] = dp[currPos.row][currPos.col] + 1; // 5.       체크인
                       q.add(new Pos('S', nextRow,  nextCol));  // 6.       큐에 넣음
                   }
                   else if (currPos.type == '*' && nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C && map[nextRow][nextCol] != 'X' && map[nextRow][nextCol] != 'D' && map[nextRow][nextCol] != '*') {
                       map[nextRow][nextCol] = '*';
                       q.add(new Pos('*', nextRow, nextCol));
                   }
                   //else if (currPos.type == 'S') System.out.println("one");
               }
           }

       }
    }

    static class Pos {
        char type;
        int row;
        int col;

        public Pos(char type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }
    }
}
