// 220418 11050 이항 계수
package wonyoung.combination;

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_11050.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        int top = Integer.parseInt(st.nextToken());
        int bottom = Integer.parseInt(st.nextToken());
        if (bottom != 0) {
            int cnt = bottom;
            int resTop = top;
            int resBottom = bottom;

            // 반복 이항계수
            for (int i = 1; i < cnt; i++) {
                resTop *= (--top);
                resBottom *= (--bottom);
            }
            bw.write(resTop / resBottom + "");
        }
        else {
            bw.write("1");
        }

        // 재귀 팩토리얼로
        //bw.write(factorial(top) / (factorial(bottom) * factorial(top - bottom)) + "");

        bw.close();
    }

    // 재귀 팩토리얼로
    // static int factorial(int N) {
    //     if (N == 0) {
    //         return 1;
    //     }

    //     return N * factorial(N - 1);
    // }
}