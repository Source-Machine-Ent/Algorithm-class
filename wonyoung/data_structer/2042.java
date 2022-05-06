// 220506 2042 구간 합 구하기
package wonyoung.data_structer;

import java.io.*;
import java.util.*;

// Indexed Tree 활용
class Main {
    static long[] tree;
    static long[] nums;
    static int N, M, K, S;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_2042.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        S = 1;
        while (S<N) S*=2;
        tree = new long[S*2];
        init(1, N, 1);
        //init();

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
        

            if (a == 1) {              
                // b번째 수를 c로 바꾸기
                long diff = c- nums[b];
                nums[b] = c;
                update(1, N, 1, b, diff);


            } else {
                // b번째 수부터 c번째 수까지의 합
                System.out.println(query(1, N, 1, b, (int) c));
            }
            
        }
        
    }

    public static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = nums[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}


    // TD
    // static void init() {
    //     for (int i = 1; i <= N; i++) {
    //         tree[S + i -1] = nums[i];
    //     }

    //     for (int i = S -1; i > 0; i--) {
    //         tree[i] = tree[i*2] + tree[i*2+1];
            
    //     }
    // }

    static long query(int left, int right, int node, int start, int end) {
        if(end < left || right < start) return 0;

        else if (start <= left && right <= end) return tree[node];

        else {
            int mid = (left + right) / 2;
            long leftResult = query(left, mid, node*2, start, end);
            long rightResult = query(mid+1, right, node*2+1,start,end);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node,int target, long diff) {
        if (target < left || right < target) return;

        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }
            else return;
        }
    }
}