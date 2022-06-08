// 220608 5582 공통 부분 문자열
package wonyoung.dp;

import java.util.*;
import java.io.*;
 
class Main {
	public static int answer;
	public static String S1, S2;
	public static int[][] memo;

    public static void main(String[] args) throws IOException {
        // for coding
        System.setIn(new FileInputStream("./input/input_5582.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S1 = br.readLine();
		S2 = br.readLine();
		
		memo = new int[S2.length() + 1][S1.length() + 1];
		
		for (int i = 0; i < S2.length(); ++i) {
			for (int j = 0; j < S1.length(); ++j) {				
				if (S2.charAt(i) == S1.charAt(j)) {
					memo[i + 1][j + 1] = memo[i][j] + 1;
					answer = (answer < memo[i + 1][j + 1]) ? memo[i + 1][j + 1] : answer;
				}
			}
		}
		
		System.out.println(answer);
	}
}
