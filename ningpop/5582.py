# 2022.06.10
# 풀이 시간: 32분 34초
# 채점 결과: 시간 초과(Python3) -> 정답(Pypy3)
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/5582

import sys

input = sys.stdin.readline

string_a = input().rstrip()
string_b = input().rstrip()

dp = [ [0] * (len(string_b) + 1) for _ in range(len(string_a) + 1) ]
maximum = 0
for i in range(1, len(dp)):
    for j in range(1, len(dp[0])):
        if string_a[i - 1] == string_b[j - 1]:
            if dp[i - 1][j - 1] != 0:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = 1
            maximum = max(maximum, dp[i][j])

print(maximum)