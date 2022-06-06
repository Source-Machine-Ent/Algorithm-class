// 220606 1722 순열의 순서
package wonyoung.combination;

import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1722.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(in.readLine()); 
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[21];
		long[] f = new long[21];
		f[0] = 1;
        for (int i = 1; i < 21; i++)
            f[i] = f[i-1] * i; 

		if(num == 1) { 
			long K = Long.parseLong(st.nextToken()); 
			
			for(int i=0; i<N; i++) { 
				for(int j=1; j<=N; j++) {
					if(visited[j]) continue;
					if(f[N-i-1] < K) K -= f[N-i-1];

					else {
						arr[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			
			for(int i=0; i<N; i++) System.out.print(arr[i]+" ");
			
		} else {
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 1L;
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<arr[i]; j++) {
					if(!visited[j]) {
						ans += f[N-i-1];
					}
				}
				visited[arr[i]] = true;
			}

			System.out.println(ans);
			
		}
		
	}
	
}