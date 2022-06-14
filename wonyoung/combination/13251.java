package wonyoung.combination;

import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static double answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_13251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        arr = new int[m];
        n = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            n += arr[i];
        }

        k = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < m; i++) {
            pick(i);
        }
        System.out.println(answer >= 1 ? 1 : answer);
    }

    static void pick(int i) {
        if (arr[i] >= k) {
            int tmp = n;
            int tmp2 = k;

            double tmpAnswer = 1;
            while (tmp2 > 0) {
                tmpAnswer *= (arr[i]-- / (double) tmp--);
                tmp2--;
            }
        }
    }

}