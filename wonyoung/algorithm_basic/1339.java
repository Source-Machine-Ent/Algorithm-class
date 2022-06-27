package wonyoung.algorithm_basic;

import java.awt.*;
import java.io.*;
import java.util.*;

class Main {

    public static int[] alpha = new int[26];


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_1339.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {
            String line = br.readLine();

            int size = line.length();

            int base = (int) Math.pow(10, size - 1);

            for (int y = 0; y < size; y++) {
                alpha[line.charAt(y) - 'A'] += base;
                base /= 10;
            }
        }

        Arrays.sort(alpha);

        int ans = 0;

        for (int x = 25; x >= 17; x--) {
            ans += alpha[x] * (x - 16);
        }

        System.out.println(ans);

    }

}