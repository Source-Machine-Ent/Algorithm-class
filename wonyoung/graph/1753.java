package wonyoung.graph;

import java.io.*;
import java.util.*;
​
class Main {
    static int v,e,k;
    static ArrayList<Node> list[];
    static int dist[];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_1753.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");
        v = Integer.parseInt(t[0]);
        e = Integer.parseInt(t[1]);
        dist = new int[v+1];
        list = new ArrayList[v+1];
        visited = new boolean[v+1];
        for(int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        k = Integer.parseInt(br.readLine());    // 시작번호
        dist[k]=0;
        for(int i=0; i<e; i++) {
            String [] currLine = br.readLine().split(" ");
            int a = Integer.parseInt(currLine[0]);    //노드1
            int b = Integer.parseInt(currLine[1]);    //노드2
            int w = Integer.parseInt(currLine[2]);    // 거리
            list[a].add(new Node(b,w));
        }
        solve();
        for(int i=1; i<=v; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
        
    }
    public static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(k,0));
        while(!pq.isEmpty()) {
            Node a = pq.poll();
            if(visited[a.idx]) {
                continue;
            }
            visited[a.idx] = true;
            for(Node o : list[a.idx]) {
                    if(dist[o.idx] > dist[a.idx]+o.w) {
                    dist[o.idx] = dist[a.idx]+o.w;
                    pq.add(new Node(o.idx,dist[o.idx]));
                }   
            }
        }
    }
}
class Node implements Comparable<Node>{
    int idx,w;
    Node(int idx,int w){
        this.idx=idx;
        this.w=w;
    }
    public int compareTo(Node o) {
        return this.w-o.w;
    }
}