// 220420 11659 구간 합 구하기 4
package wonyoung.dp;

import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int nums[];
	static int sums[];

    static public void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_11659.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        sums = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        	if (i > 0) sums[i] = nums[i] + sums[i-1];
        	else sums[0] = nums[0];
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ", false);
        	int start = Integer.parseInt(st.nextToken()) - 1;
        	int end = Integer.parseInt(st.nextToken()) - 1;
        	if (start == 0) System.out.println(sums[end]+ "");
        	else System.out.println((sums[end] - sums[start -1]) + "");
        }  
    }
}