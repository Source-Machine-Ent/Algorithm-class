package wonyoung.data_structer;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1927.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x));

        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(val);
            }
        }
    }
}