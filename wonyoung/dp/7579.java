// 220601 7579 앱
package wonyoung.dp;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_7579.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st = new StringTokenizer(br.readLine());           
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());       
		int result = Integer.MAX_VALUE;
        
		int[] costs = new int[N];       
		int[] memory = new int[N];
		int[][] dp = new int[N][100001];
        
		StringTokenizer st1 = new StringTokenizer(br.readLine());  
		StringTokenizer st2 = new StringTokenizer(br.readLine());  
        
		for(int i = 0; i < N; i++){
			memory[i] = Integer.parseInt(st1.nextToken());
			costs[i] = Integer.parseInt(st2.nextToken());
		}
        
		for(int i = 0; i < N; i++) {  
			int cost = costs[i];
			int mem = memory[i];
            
			for(int j = 0; j <= 10000; j++){	
				if(i == 0) {
					if (j >= cost) dp[i][j] = mem;
				}else {
					if (j >= cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + mem, dp[i - 1][j]);
					else dp[i][j] = dp[i - 1][j];
				}	
				if(dp[i][j] >= M) result = Math.min(result, j);
			}
		}	

		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}