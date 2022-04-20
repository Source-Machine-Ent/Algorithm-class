// 220420 10845 큐

package wonyoung.data_structer;

import java.io.*;
import java.util.*;
 
class Main {
    public static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_10845.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int count = Integer.parseInt(br.readLine());
        
        queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        int back = -1;
        
        while(count-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            String order = st.nextToken();
            
            if("push".equals(order)) {
                back = Integer.parseInt(st.nextToken());
                queue.offer(back);
            }else if("size".equalsIgnoreCase(order)) {
                sb.append(queue.size() + "\n");
            }else if("empty".equals(order)) {
                if(queue.size() == 0) sb.append("1 \n");
                else sb.append("0 \n");
            }else if("pop".equals(order)) {
                if(queue.size() == 0) sb.append("-1 \n");
                else sb.append(queue.poll() + "\n");
                
                if(queue.size() == 0) back = -1;
            }else if("front".equals(order)) {
                if(queue.size() == 0) sb.append("-1 \n");
                else sb.append(queue.peek() + "\n");
            }else if("back".equals(order)) {
                sb.append(back + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}