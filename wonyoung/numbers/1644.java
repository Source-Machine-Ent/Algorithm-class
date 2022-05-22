package wonyoung.numbers;

import java.io.*;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static boolean prime[] = new boolean[4_000_001];
    static List<Integer> prime_list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
      // for coding
        System.setIn(new FileInputStream("./input/input_1644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        prime();
        int size = prime_list.size();

        int count = 0;
        int left = 0;
        int right = 0;

        while (true) {
            int sum = sum(left, right);
            if (sum == N) {
                count += 1;
                right += 1;
            } else if (sum < N) {
                right += 1;
            } else {
                left += 1;
            }
            if (right == size || left == size || left > right) {
                break;
            }
        }

        System.out.println(count);
    }

    static void prime() {

        int n = 4000000;
        // 소수가 아니면 true
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i < 4000001; i++) {
            if (!prime[i]) {
                prime_list.add(i);
            }
        }
    }

    static int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += prime_list.get(i);
        }
        return sum;
    }
}
