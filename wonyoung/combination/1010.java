// 220425 1010 다리 놓기

import java.io.*;
import java.util.*;

class Main {
	public static int dp[][] = new int[30][30];
	public static void main(String[] args) throws IOException{
    // for coding
    System.setIn(new FileInputStream("./input/input_1010.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(M, N)).append('\n');
		}
		
		System.out.println(sb);
		
	}

	public static int bridge(int m, int n) {
		if(dp[m][n] > 0) return dp[m][n]; 
		if(m == n || n == 0) return dp[m][n] = 1;
		return dp[m][n] = bridge(m - 1, n - 1) + bridge(m - 1, n);
		// n+1 C r+1 = n C r + n C r+1
		
			
	}
}
