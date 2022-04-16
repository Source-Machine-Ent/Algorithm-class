// 220416 분수 합

package wonyoung.numbers;

import java.io.*;
import java.util.*;

class Main {
    public static int aTop, aBottom, bTop, bBottom, resTop, resBottom;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1735.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        aTop = Integer.parseInt(st.nextToken());
        aBottom = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ", false);

        bTop = Integer.parseInt(st.nextToken());
        bBottom = Integer.parseInt(st.nextToken());

        resTop = aTop * bBottom + bTop * aBottom;
        resBottom = aBottom * bBottom;

        int mod = gcd(resTop, resBottom);
        resTop /= mod;
        resBottom /= mod;

        bw.write(resTop + " " + resBottom);

        bw.close();
    }
    
    public static int gcd(int a, int b) {
        if (a <= b) {
            int temp = a;
            a = b;
            b = temp;
        }

        return b==0? a : gcd(b , a % b);
    }

}
