package wonyoung.dp;

import java.io.*;
import java.util.*;


class Main {

	static int N;
	static int[] input;
	static int[][] dp;

	static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_5626.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		input = new int[N];
		dp = new int[N][(N / 2) + 2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (input[i] > Math.min(i, (N - 1) - i)) {
				bw.write(String.valueOf(0));
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}

		dp[0][0] = 1;
		int len;
		for (int i = 1; i < N; i++) {
			len = Math.min(i, (N-1)-i);
			for(int j=0; j<=len; j++) {
				dp[i][j] = 0;
			}
			
			if (input[i] == -1) {
				len = Math.min(i, (N-1)-i);
				for (int j = 0; j <= len; j++) {
					
					for (int k=-1; k<=1; k++) {
						int adjHeight = j + k;
						if (adjHeight < 0) continue;
						
						dp[i][j] += dp[i-1][adjHeight];
						dp[i][j] %= MOD;
					}
				}
			}
			
			else {
				for (int k=-1; k<=1; k++) {
					int adjHeight = input[i] + k;
					if (adjHeight  < 0) continue;
					
					dp[i][input[i]] += dp[i-1][adjHeight];
					dp[i][input[i]] %= MOD;
				}
			}
		}

		bw.write(String.valueOf(dp[N-1][0] % MOD));

		bw.flush();
		bw.close();
		br.close();
	}
}