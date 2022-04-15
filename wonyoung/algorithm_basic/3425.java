// 220414 3425 고스택
package wonyoung.algorithm_basic;

import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<String[]> list = new ArrayList<>();
    public static Stack<long[]> stack = new Stack<>();
    public static long n;
    static long MAX = 1000000000;


    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_3425.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            String cmd;
            while (true) {
                st = new StringTokenizer(br.readLine());

                if (!st.hasMoreTokens()) {
                    list.clear();
                    System.out.println();
                    continue;
                }
                cmd = st.nextToken();
                if (cmd.equals("NUM")) {
                    String num = st.nextToken();
                    list.add(new String[] { cmd, num });
                } else if (cmd.equals("END") || cmd.equals("QUIT")) {
                    break;
                } else {
                    list.add(new String[] { cmd });
                }
            }
            if ("QUIT".equals(cmd))
                break;


            boolean isNumber = false;
            st = new StringTokenizer(br.readLine());

            int tc = Integer.parseInt(st.nextToken());
            while (tc-- > 0) {
                st = new StringTokenizer(br.readLine());

                n = Long.parseLong(st.nextToken());
                isNumber = solution();
                if (!isNumber || stack.size() != 1) {
                    System.out.println("ERROR");
                } else {
                    if (Math.abs(stack.peek()[0]) > MAX)
                        System.out.println("ERROR");
                    else
                        System.out.println(stack.peek()[0]);
                }

                while (!stack.isEmpty())
                    stack.pop();
            }

            while (!list.isEmpty())
                list.remove(0);

        }

    }
    
// action for each command
    public static boolean solution() {
        stack.push(new long[] {n});
        for (String[] currList : list) {
            if (currList[0].equals("NUM")) {
                stack.push(new long[] {Long.parseLong(currList[1])});
            } else if (currList[0].equals("POP")) {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            } else if (currList[0].equals("INV")) {
                if (stack.isEmpty())
                    return false;
                long a = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {-a});
            } else if (currList[0].equals("DUP")) {
                if (stack.isEmpty())
                    return false;
                stack.push(stack.peek());
            } else if (currList[0].equals("SWP")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num1});
                stack.push(new long[] {num2});
            } else if (currList[0].equals("ADD")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num1+num2});
            } else if (currList[0].equals("SUB")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num2-num1});
            } else if (currList[0].equals("MUL")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num1*num2});
            } else if (currList[0].equals("DIV")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                if (num1 == 0)
                    return false;
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num2/num1});
            } else if (currList[0].equals("MOD")) {
                if (stack.size() < 2)
                    return false;
                long num1 = stack.peek()[0];
                stack.pop();
                if (num1 == 0)
                    return false;
                long num2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {num2%num1});
            }
        }
        return true;
    }
}