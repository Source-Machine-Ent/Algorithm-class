package wonyoung.algorithm_basic;

import java.util.*;
import java.io.*;

class Main {
    static int N; // 사진틀의 개수
    static int voteCnt; // 총 투표 수
    static List<Candidate> frames;

    public static void main(String[] args) throws Exception {
        // for coding
        System.setIn(new FileInputStream("./input/input_1713.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        voteCnt = Integer.parseInt(br.readLine());
        frames = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < voteCnt; i++) {
            int currVoteNum = Integer.parseInt(st.nextToken());
            boolean isInFrames = false;

            // 이미 후보가 등록이 되었는지
            for (int j = 0 ; j<frames.size();j++){
                // 있으면 득표수만 추가
                if (frames.get(j).num == currVoteNum) {
                    frames.set(j, new Candidate(currVoteNum, frames.get(j).votesGot+1, frames.get(j).turn));
                    isInFrames = true;
                    break;
                }
            }

            if (!isInFrames) {
                // 없는데 사진틀이 남음
                if (frames.size() < N) frames.add(new Candidate(currVoteNum, 1, i));
                
                // 없는데 사진틀 만석
                else {
                    // 등록시간 오름차순 정렬
                    Collections.sort(frames, Comparator.comparing(Candidate::getTurn));

                    // 득표수 오름차순 정렬
                    Collections.sort(frames, Comparator.comparing(Candidate::getVotesGot));

                    frames.set(0, new Candidate(currVoteNum, 1 ,i));
                }
            }
        }

        Collections.sort(frames, Comparator.comparing(Candidate::getNum));
        for (int i = 0; i < frames.size(); i++) {
            if (i == 0 )  System.out.print(frames.get(0).num + "");
            else System.out.print(" " + frames.get(i).num);
        }
    }
}

class Candidate {
    int num;
    int votesGot;
    int turn; // 수가 작을수록 일찍 등록

    public Candidate(int num, int votesGot, int turn) {
        this.num = num;
        this.votesGot = votesGot;
        this.turn = turn;
    }

    public int getNum() {
        return num;
    }

    public int getVotesGot() {
        return votesGot;
    }

    public int getTurn() {
        return turn;
    }
}