package wonyoung.dp;

import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_9252.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		char[] str1 = br.readLine().toCharArray();
		int l1 = str1.length;
		char[] str2 = br.readLine().toCharArray();
		int l2 = str2.length;

		int[][] dp = new int[l2 + 1][l1 + 1];

		for (int i = 1; i <= l2; i++) {
			char C = str2[i - 1];
			for (int j = 1; j <= l1; j++) {
				if (C == str1[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		sb.append(dp[l2][l1]).append("\n");

		int now = dp[l2][l1];
		int x = l2;
		int y = l1;

		while (isIn(x, y) && now > 0) {
			if (dp[x - 1][y] == now) {
				x--;
			} else if (dp[x][y - 1] == now) {
				y--;
			} else {
				x--;
				y--;
				now--;
				stack.push(str1[y]);
			}

		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 < x && 0 < y) {
			return true;
		}
		return false;
	}
}
