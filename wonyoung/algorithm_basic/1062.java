// 220428 1062 가르침
package wonyoung.algorithm_basic;

import java.io.*;
import java.util.*;

class Main {
	static int N, K, sol;
	static int possible;
	static String[] words;
	static boolean[] alpha;
	
	public static void main(String[] args) throws IOException {
		// for coding
        System.setIn(new FileInputStream("./input/input_1062.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		sol = 0;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(K<5) {
			bw.write(String.valueOf(sol));
			br.close();
			bw.flush();
			bw.close();
			return;
		}		
		
		words = new String[N];
		String word; 
		for(int i=0; i<N; i++) {
			word = br.readLine();
			words[i] = word.substring(4, word.length()-4);
		}
				
		alpha = new boolean[26];
		alpha['a'-'a'] = true;
		alpha['c'-'a'] = true;
		alpha['i'-'a'] = true;
		alpha['n'-'a'] = true;
		alpha['t'-'a'] = true;
		possible = K-5; 

		dfs(1,0);

		
		bw.write(String.valueOf(sol));
		
		br.close();
		bw.flush();
		bw.close();
	}
	

	static void dfs(int id, int cnt) {
		if(cnt==possible) {
			int result = wordCnt();
			sol = result > sol? result : sol;
			return;
		}
		if (id>=26) return;
		if (alpha[id]==false) {
			alpha[id] = true;
			dfs(id+1, cnt+1);
			alpha[id] = false;
		}
		dfs(id+1, cnt);
	}


	static int wordCnt() {
		String word;	    
		boolean tFlag;	  
		int result = 0;	
		
		for(int i=0; i<N; i++) {
			tFlag = true;
			word = words[i];
			int len = word.length();
			for (int j=0; j<len; j++) {
				char check = word.charAt(j);
				if (alpha[check-'a']==false) {
					tFlag = false;
					break;
				}
			}
			if (tFlag) result++;
		}
		return result;
	}
}