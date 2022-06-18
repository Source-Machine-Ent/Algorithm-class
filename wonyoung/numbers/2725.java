package wonyoung.numbers;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_2725.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        int dp[] = new int[1001];

        dp[1] = 3;
        for (int i = 2; i <= 1000; i++)
        {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i == j)
                    continue;
                if (gcd(i, j) == 1)
                    cnt += 2;
                dp[i] = dp[i - 1] + cnt;
            }
        }

        for (int i = 0;i<C;i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        while (a % b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}
