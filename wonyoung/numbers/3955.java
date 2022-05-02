// 220430

package wonyoung.numbers;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1735.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			long[] res = eeg(k,c);
			if(res[1] != 1) {
				System.out.println("IMPOSSIBLE");
			}else {
				long t0 = res[0];
				
				t0 = (t0% k + k) % k;
                t0 = Math.max(t0, (k+c)/c);
				
				if(t0 <= 1e9) {
					System.out.println(t0);
				}else { 
					System.out.println("IMPOSSIBLE");
				}
			}
		}
	}
	
	static long[] eeg(long a, long b) {
		long r0 = a, r1 = b;
		long s0 = 1, s1 = 0;
		long t0 = 0, t1 = 1;
		
		long tmp;
		while(r1 != 0) {
			long q = r0/r1;
			tmp = r0 - q*r1;
			r0 = r1;
			r1 = tmp;

			tmp = s0 - q*s1;
			s0 = s1;
			s1 = tmp;

			tmp = t0 - q*t1;
			t0 = t1;
			t1 = tmp;
		}

		return new long[] {t0, r0};

	}
}