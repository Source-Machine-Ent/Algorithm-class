import java.io.*;
import java.util.Arrays;
 
class Main {
    private static final int  MAX_N = 1_000_000;
    private static long[] segmentTree = new long[MAX_N * 4];
    private static long[] arr;

    public static void main(String[] args) throws Exception {
      // for coding
        System.setIn(new FileInputStream("./input/input_14476.txt"));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
 
            int firstLeafNodeIdx = getFirstLeafNodeIdx(N);
            init(firstLeafNodeIdx, N);
            solve(firstLeafNodeIdx, N);
        }
    }
 
    private static void solve(int firstIdx, int n) {
        long maxGcd = 0;
        long removeVal = 0; //
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            long curNum = arr[i];
 
            updateSegmentTree(firstIdx, i, 0);

            if (arr[i] % segmentTree[1] != 0 && maxGcd < segmentTree[1]) {
                maxGcd = segmentTree[1];
                removeVal = arr[i];
            }
 
            if (arr[i] % segmentTree[1] == 0) {
                cnt++;
            }

            updateSegmentTree(firstIdx, i, curNum);
        }
 
        if (cnt == n) {
            System.out.println("-1");
        } else {
            System.out.println(maxGcd + " " + removeVal);
        }
    }
 
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int getFirstLeafNodeIdx(long n) {
        int ret = 1;
        while (ret < n) {
            ret *= 2;
        }
        return ret;
    }
 
    private static void init(int firstLeafNodeIdx, int n) {
        for (int i = firstLeafNodeIdx; i < firstLeafNodeIdx + n; i++) {
            segmentTree[i] = arr[i - firstLeafNodeIdx];
        }
        for (int i = firstLeafNodeIdx - 1; i >= 1; i--) {
            segmentTree[i] = gcd(segmentTree[i * 2], segmentTree[i * 2 + 1]);
        }
    }
 
    private static void updateSegmentTree(int firstIdx, int updateIdx, long newValue) {
        int tmpIdx = firstIdx + updateIdx;
        segmentTree[tmpIdx] = newValue;
        while (tmpIdx >= 1) {
            tmpIdx /= 2;
            segmentTree[tmpIdx] = gcd(segmentTree[tmpIdx * 2], segmentTree[tmpIdx * 2 + 1]);
        }
    }
}
