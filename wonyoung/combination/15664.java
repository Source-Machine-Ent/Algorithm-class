package wonyoung.combination;

import java.io.*;
import java.util.*;

class Main {
    static int n, r;
    static int[] num;
    static int[] arr;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_15664.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        num = new int[r];
        arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
        bt(0, 0);
        StringBuilder sb = new StringBuilder();
        set.stream().forEach(i->sb.append(i));
        System.out.print(sb);
    }
    static void bt(int depth, int start){
        if (depth == r){
            String str = "";
            for (int i : num) str += i + " ";
            set.add(str+"\n");
            return;
        }
        for (int i=start; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                num[depth] = arr[i];
                bt(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}