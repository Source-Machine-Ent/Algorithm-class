// 220427 11660 구간 합 구하기 5
package wonyoung.dp;

import java.util.*;
import java.io.*;

class Main {
   public static void main(String[] args) throws Exception {
      // for coding
      System.setIn(new FileInputStream("./input/input_11659.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
     
      StringBuilder sb = new StringBuilder();
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[][] map = new int[n+1][n+1];
      for(int i=1;i<=n;i++) {
    	  st = new StringTokenizer(br.readLine());
    	  for(int j=1;j<=n;j++) {
    		  map[i][j] = Integer.parseInt(st.nextToken());
    	  }
      }
      
      int[][] dp = new int[n+1][n+1];
      for(int i=1;i<=n;i++) {
    	  for(int j=1;j<=n;j++) {
    		  dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
    	  }
      }
      
      int x1, y1, x2, y2;
      for(int mm=0;mm<m;mm++) {
    	  st = new StringTokenizer(br.readLine());
    	  x1= Integer.parseInt(st.nextToken());
    	  y1= Integer.parseInt(st.nextToken());
    	  x2= Integer.parseInt(st.nextToken());
    	  y2= Integer.parseInt(st.nextToken());
    	  sb.append(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]).append("\n");
      }
     bw.write(sb+"");
     bw.close();
   }

}
