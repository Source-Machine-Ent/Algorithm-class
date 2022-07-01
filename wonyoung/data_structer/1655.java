package wonyoung.data_structer;

import java.io.*;
import java.util.*;

public class Main{

    static int N;

    public static void main(String[] args)throws IOException {
        System.setIn(new FileInputStream("./input/input_1655.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) maxHeap.add(Integer.parseInt(br.readLine()));
            else minHeap.offer(Integer.parseInt(br.readLine()));

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
