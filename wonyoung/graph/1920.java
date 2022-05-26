// 220526 1920 수 찾기
package wonyoung.graph;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1920.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];     // 입력 받은 값을 넣기 위해 배열 선언

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);           // 배열을 오름차순으로 정렬

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            int mid = (arr.length / 2);     // 시간을 줄이기 위해서 범위를 반으로 나누기
            if (a >= arr[mid]) {            // 중간값과 비교하여 절반만 비교 수행
                for (int j = mid; j < arr.length; j++) {
                    if (arr[j] == a) {
                        result[i] = 1;      // 만약 값이 있다면? 결과배열에 1을 넣어주고 break!
                        break;
                    }
                }
            } else {
                for (int j = mid - 1; j >= 0; j--) {
                    if (arr[j] == a) {
                        result[i] = 1;
                        break;
                    }
                }
            }
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}