package wonyoung.graph;

import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int [] Group;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // for coding
        System.setIn(new FileInputStream("./input/input_1717.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Group = new int [N + 1];
        for(int i = 0 ; i<= N ; i++) {
            Group[i] = i;
        }

        int Q, a, b;
        for(int i = 1 ; i <= M ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Q = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(Q == 0) {
                union (a, b);
            }

            if (Q == 1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int aGroup = find(a);
        int bGroup = find(b);

        Group[aGroup] = bGroup;
    }

    static int find(int i) {
        if (Group[i] == i) return i;

        else return Group[i] = find(Group[i]);
    }
}
