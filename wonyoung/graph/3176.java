// 220531 3176 도로 네트워크
package wonyoung.graph;

import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int K;

	static int minValue;
	static int maxValue;

	static int depth [];
	static boolean visited [];

	static int parent[][];
	static int minList[][];
	static int maxList[][];

	static ArrayList<Integer> [] aList;
	static ArrayList<Integer> [] cList;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_3176.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		aList = new ArrayList [N+1];
		cList = new ArrayList [N+1];
		for (int i = 0; i<=N; i++) {
			aList[i] = new ArrayList<Integer>();
			cList[i] = new ArrayList<Integer>();
		}
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            aList[s].add(e);
            aList[e].add(s);
            cList[s].add(c);
            cList[e].add(c);
        }

		depth = new int [N+1];
		visited = new boolean [N+1];

		int t = 1;
		K=0;
        while (t <= N) {
            t <<= 1;
            K++;
        }

		parent = new int [N+1][K];
		minList = new int [N+1][K];
		maxList = new int [N+1][K];
		for (int i = 0; i<=N; i++) {
			minList[i][0] = Integer.MAX_VALUE;
			maxList[i][0] = 0;
		}
		dfs(1,0);
		fillParent();
		int Q = Integer.parseInt(br.readLine());
		minValue = 0;
		maxValue = 0;

		for (int i= 0; i<Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			getLCA(x,y);
			System.out.println(minValue + " " + maxValue);
		}
	}

	private static void print() {
		for (int i = 1; i<=N; i++) {
			System.out.print(depth[i] + " ");
		}System.out.println();
		for (int i = 1; i<=N; i++) {
			System.out.print(parent[i][0] + " ");
		}System.out.println();
		for (int i = 1; i<=N; i++) {
			System.out.print(minList[i][0] + " ");
		}System.out.println();
		for (int i = 1; i<=N; i++) {
			System.out.print(maxList[i][0] + " ");
		}System.out.println();
	}

	private static void getLCA(int a, int b) {
		int rmin = Integer.MAX_VALUE;
		int rmax = Integer.MIN_VALUE;

		if (depth[a] < depth[b]) {
			int temp = b;
			b = a;
			a = temp;
		}

		for (int i = K-1; i>=0; i--) {
			int diff = depth[a] -depth[b];
			if ((diff & (1<<i)) != 0) {
				rmin = Math.min(rmin, minList[a][i]);
				rmax = Math.max(rmax, maxList[a][i]);
				a = parent[a][i];
			}
		}

		if (a==b) {
			minValue = rmin;
			maxValue = rmax;
			return;
		}

		for (int i = K-1; i>=0; i--) {
			if (parent[a][i] != parent[b][i]) {
				rmin = Math.min(minList[b][i],Math.min(rmin, minList[a][i]));
				rmax = Math.max(maxList[b][i],Math.max(rmax, maxList[a][i]));
			    a = parent[a][i];
				b = parent[b][i];
            }
		}
		minValue = Math.min(minList[b][0],Math.min(rmin, minList[a][0]));
		maxValue = Math.max(maxList[b][0],Math.max(rmax, maxList[a][0]));
	}

	private static void fillParent() {
		for (int i = 1; i<K; i++) {
			for (int j = 1; j<=N; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
				minList[j][i] = Math.min(minList[j][i-1], minList[parent[j][i-1]][i-1]);
				maxList[j][i] = Math.max(maxList[j][i-1], maxList[parent[j][i-1]][i-1]);
			}
		}
	}

	private static void dfs(int node, int dep) {
		depth[node] = dep;
		visited[node] = true;

		for (int i = 0; i<aList[node].size(); i++) {
			int x = aList[node].get(i);
			if (!visited[x]) {
				parent[x][0] = node;
				minList[x][0] = cList[node].get(i);
				maxList[x][0] = cList[node].get(i);
				dfs(x,dep+1);
			}
		}
	}
}