// 220419 2252 줄세우기
package wonyoung.graph;

import java.io.*;
import java.util.*;
class Main {
    static int N, M;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static Queue<Integer> q;

    public static void main(String [] args) throws Exception {
      // for coding
        System.setIn(new FileInputStream("./input/input_2252.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        q = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            indegree[end]++;
            edges.get(start).add(end);
        }

        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) q.add(i);

        while(!q.isEmpty()) {
            //bw.write("\n" + indegree[1] + " " +indegree[2] + " " + indegree[3] + " " +indegree[4] + "\n");
            int num = q.poll();

            bw.write(num+" ");

            for (int i = 0; i < edges.get(num).size(); i++) {
                int curr = edges.get(num).get(i);
                indegree[curr]--;
                if(indegree[curr] == 0) q.add(curr);
            }
            //indegree[edges.get()]--;
            //if (indegree[edges[num]] == 0) q.add(edges[num]);
        }

        bw.close();
    }
}
