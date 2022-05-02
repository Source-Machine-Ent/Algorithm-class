// 220502 1256 사전
package wonyoung.combination;

import java.io.*;
import java.util.*;

class Main {
    static int N, M, K, num = 0, count = 0;
    static char result[];
    static boolean check[][];
    static long cnt[][];
    public static long mod=1000000001;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1256.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = new long[200 + 1][100 + 1];
        check = new boolean[200 + 1][100 + 1];
        result = new char[200 + 1];
        StringBuilder sb = new StringBuilder();

        long num = binary(N + M, M);
        if (num >= K) {
            Arrays.fill(result, 'a');
            find(N + M, M, K );
        for (int i = 0; i < N + M; i++)
            sb.append(result[i]);
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    public static long binary(int n, int m) {
        if (n < m)
            return 0;
        if (n == m || m == 0)
            return 1;
        if (check[n][m])
            return cnt[n][m];

        check[n][m] = true;
        cnt[n][m] += binary(n - 1, m);
        cnt[n][m] += binary(n - 1, m - 1);
        return Math.min(cnt[n][m], 1000000001);
    }

    public static void find(int n, int m, long k) {
        if (n == 0) return;
        if (m == 0) {
        for (int i = 0; i < n; i++)
            result[num + i] = 'a';
        return;
        }
        long pivot = binary(n - 1, m);
        if (pivot < k) {
            result[num++] = 'z';
            find(n - 1, m - 1, k - pivot);
        } else {
            result[num++] = 'a';
            find(n - 1, m, k);
        }
        }
}
