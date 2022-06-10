// 20220610 9202 Boggle 결국 이 문제가 나오네ㅜㅜㅜㅜㅜ
// 몇 번을 다시 풀어도 힘들어..

package wonyoung.data_structer;

import java.io.*;
import java.util.*;

class Main {
	static int N, size;
	static Trie trie = new Trie();
	static char[][] cube = new char[4][4];
	static boolean[][] visit = new boolean[4][4];
	static char[] string;
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static HashSet<String> hs = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./input/input_9202.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			trie.add(br.readLine());
		}
		br.readLine();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				char[] temp = br.readLine().toCharArray();
				for (int k = 0; k < 4; k++) {
					cube[j][k] = temp[k];
				}
			}
			hs.clear();
			search();
			if (i != N - 1) br.readLine();
			result();
		}
		System.out.println(sb.toString());
	}

	private static void search() {
		for (int i = 1; i <= 8; i++) {
			isPossible(i);
		}
	}

	private static void isPossible(int length) {
		size = length;
		string = new char[size];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				string[0] = cube[i][j];
				visit[i][j] = true;
				dfs(i, j, 1);
				visit[i][j] = false;
			}
		}
	}

	private static void dfs(int x, int y, int depth) {
		if (depth == size) {
			if (trie.isContain(depth) && !hs.contains(String.copyValueOf(string))) hs.add(String.copyValueOf(string));
			return;
		}

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && !visit[nx][ny]) {
				string[depth] = cube[nx][ny];
				visit[nx][ny] = true;
				dfs(nx, ny, depth + 1);
				visit[nx][ny] = false;
			}
		}
	}

	private static void result() {
		ArrayList<String> list = new ArrayList<>(hs);
		Collections.sort(list);
		int point = 0, count = 0;
		String result = "";

		for (String s : list) {
			if (s.length() > result.length()) result = s;
			point += calc(s);
			count++;
		}
		sb.append(point + " " + result + " " + count + "\n");
	}

    private static int calc(String s) {
        if (s.length() <= 2)
            return 0;
        else if (s.length() == 3)
            return 1;
        else if (s.length() <= 6)
            return s.length() - 3;
        else if (s.length() == 7)
            return 5;
        else if (s.length() == 8)
            return 11;
        return -1;
    }
    
    	private static class Node {
		char data;
		boolean isEnd;
		Node[] child;

		Node(char c) {
			data = c;
			child = new Node[27];
		}

		Node setChild(char c) {
			if (c == '\0') {
				isEnd = true;
				return null;
			}

			if (child[c - 'A'] == null) child[c - 'A'] = new Node(c);
			return child[c - 'A'];
		}
	}

	private static class Trie {
		Node n;

		Trie() {
			n = new Node('\0');
		}

		void add(String s) {
			Node n = this.n;

			for (int i = 0; i < s.length(); i++) {
				n = n.setChild(s.charAt(i));
			}
			n.setChild('\0');
		}

		boolean isContain(int length) {
			Node n = this.n;

			for (int i = 0; i < length; i++) {
				if (n.child[string[i] - 'A'] == null) {
					return false;
				}
				n = n.child[string[i] - 'A'];
			}
			return n.isEnd;
		}
	}
}