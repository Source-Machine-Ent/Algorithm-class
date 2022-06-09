// 20220609 1759 암호만들기
package wonyoung.algorithm_basic;

import java.io.*;
import java.util.*;

class Main {
    static int L, C;
    static char[] letters;
    static char[] result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_1759.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = new char[C];
        letters = new char[C];

        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        BFS(0,0,0,0);

        // 1. 체크인
        // 2. 목적지인가?
        // 3. 연결
        // 4.   갈 수있나?
        // 5.   간다
        // 6. 체크아웃

    }
    
    static void BFS(int start, int depth, int ja, int mo) {
        for (int i = start; i < C; i++) {
            result[i] = 1;
            int j = ja;
            int m = mo;

            if(letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i'|| letters[i] == 'o' || letters[i] == 'u') m++;
            else j++;

            BFS(i+1,depth+1,j,m);

            result[i] = 0;
        }

        if(depth == L && ja >= 2 && mo >= 1) {
            for (int k = 0; k < C; k++) {
                if (result[k] == 1) System.out.print(letters[k] + "");
            }
            System.out.println();
        }
        
    }
}