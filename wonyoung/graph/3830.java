// 220524 3830 교수님은 기다리 않는다

package wonyoung.graph;

import java.io.*;
import java.util.*;


class Main {
	static int n,m;
	static int[] dist,parent;
	
    public static void main(String[] args) throws Exception {
    	// for coding
        System.setIn(new FileInputStream("./input/input_3830.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int a,b,weight;
    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		if(n==0&&m==0) break;
    		
    		dist = new int[n+1];
    		parent = new int[n+1];
    		for(int i=1; i<=n; i++) {
    			parent[i]=i;
    		}
    		for(int i=0; i<m; i++) {
    			st = new StringTokenizer(br.readLine());
    			if(st.nextToken().equals("!")) {
    				a = Integer.parseInt(st.nextToken());
    				b = Integer.parseInt(st.nextToken());
    				weight = Integer.parseInt(st.nextToken());
    				union(a,b,weight);
    			}
    			else {
    				a = Integer.parseInt(st.nextToken());
    				b = Integer.parseInt(st.nextToken());
    				if(find(a)==find(b)) {
    					sb.append(dist[b]-dist[a]).append('\n');
    				}
    				else sb.append("UNKNOWN").append('\n');
    			}
    		}
    	}
    	System.out.print(sb);
    }
    static void union(int a, int b, int gap) {
    	int u1 = find(a);
    	int u2 = find(b);
    	if(u1!=u2) {
    		parent[u2]=u1;
    		dist[u2]=dist[a]+gap-dist[b];
    	}
    }
    static int find(int a) {
    	if(parent[a]==a) return a;
    	int p = find(parent[a]);
    	dist[a]+=dist[parent[a]];
    	return parent[a]=p;
    }
}