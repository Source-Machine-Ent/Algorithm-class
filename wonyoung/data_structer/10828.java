// 220415 10828 스택
package wonyoung.data_structer;

import java.io.*;
import java.util.*;

class Main {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_10828.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);

            // recognize command
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int token = Integer.parseInt(st.nextToken());
                stack.push(token);
            } else if (cmd.equals("top")) {
                if (stack.size() == 0)
                    bw.write("-1\n");
                else
                    bw.write(stack.peek() + "\n");
            } else if (cmd.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (cmd.equals("pop")) {
                if (stack.size() == 0)
                    bw.write("-1\n");
                else
                    bw.write(stack.pop() + "\n");
            } else if (cmd.equals("empty")) {
                bw.write(stack.empty() ? "1" : "0");
                bw.write("\n");
            }
        }

        bw.close();
    }
}