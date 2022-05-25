package wonyoung.graph;

import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        // for coding
        System.setIn(new FileInputStream("./input/input_14003.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int num=Integer.parseInt(br.readLine());

        int[] list=new int[num+1];
        int[][] dp=new int[num+1][2];
        int[] trace=new int[num+1];

        int start=0,end=0;

        StringTokenizer st=new StringTokenizer(br.readLine());

        dp[0][0]=-1000000001;
        dp[0][1]=-1;

        for(int x=1;x<=num;x++){
            list[x] = Integer.parseInt(st.nextToken());

            int n_start=start;
            int n_end=end;

            while(n_start<n_end){
                int middle=(n_start+n_end)/2;

                if(dp[middle][0]>=list[x])
                    n_end=middle;
                else
                    n_start=middle+1;
            }

            if(end==n_end && dp[end][0]<list[x]){
                end++;
                n_end++;
            }

            dp[n_end][0]=list[x];
            dp[n_end][1]=x;
            trace[x]=dp[n_end-1][1];
        }


        bw.write(String.valueOf(end)+"\n");

        int last=dp[end][1];

        int [] answer=new int[end];

        for(int x=end-1;x>=0;x--){
            answer[x]=list[last];
            last=trace[last];
        }

        for(int x=0;x<end;x++){
            bw.write(String.valueOf(answer[x]+" "));
        }

        bw.flush();
        bw.close();

        br.close();
    }


}