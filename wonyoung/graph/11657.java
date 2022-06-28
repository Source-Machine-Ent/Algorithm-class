package wonyoung.graph;

import java.io.*;
import java.util.*;

class Main {

	static class Edge {
		int start, target, cost;

		public Edge(int start, int target, int cost) {
			this.start = start;
			this.target = target;
			this.cost = cost;
		}
	}

	static int N, M;
	static long[] dist;
	static Edge[] edgeList;
	static int ans;
	static boolean infFlag;

	static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_11657.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeList = new Edge[M + 1];

		int a, b, c;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(a, b, c);
		}

		dist = new long [N+1];
		for (int i = 2; i <= N; i++) {
			dist[i] = INF;
		}
		BellmanFord();

		if (infFlag) {
			bw.write("-1");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i<=N; i++) {
				if (dist[i]==INF) {
					sb.append("-1\n");
				}
				else {
					sb.append(dist[i]+"\n");
				}
			}
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static void BellmanFord() {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= M; j++) {
				Edge now = edgeList[j];
				if (dist[now.start] == INF)
					continue;
				dist[now.target] = Math.min(dist[now.target], dist[now.start] + now.cost);
			}
		}

		for (int j = 1; j <= M; j++) {
			Edge now = edgeList[j];

			if (dist[now.start] == INF)
				continue;

			if (dist[now.start] + now.cost < dist[now.target]) {
				infFlag = true;
				return;
			}
		}
	}

}