// 220511 1915 가장 큰 사각형
package wonyoung.dp

import java.util.*;
import java.io.*;

public class Main {
        // for coding
        System.setIn(new FileInputStream("./input/input_1915.txt"));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, maxNum = 0;
	static char[][] map;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				dp[i][j] = map[i][j] - '0';
				if(dp[i][j] == 1 && maxNum == 0) maxNum =1;
				if (j > 0 && i > 0) {
					if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j] == 1) {
						dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
						maxNum = Math.max(dp[i][j], maxNum);
					}
				}
			}
		}
		System.out.println(maxNum* maxNum);
	}
}
