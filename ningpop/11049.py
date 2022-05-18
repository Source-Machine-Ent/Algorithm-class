# 2022.05.18
# 풀이 시간 93분 45초
# 채점 결과: 시간 초과(Python3), 정답(Pypy3)
# 시간복잡도: O(N^3)
# 문제 링크: https://www.acmicpc.net/problem/11049

import sys

input = sys.stdin.readline

n = int(input())
arrays = list(map(int, input().split()))
for _ in range(n - 1):
    r, c = map(int, input().split())
    arrays.append(c)

dp = [ [0] * n for _ in range(n) ]
for col in range(n):
    for i in range(n - col):
        j = col + i

        if i == j:
            continue

        dp[i][j] = 1e9
        for k in range(i, j):
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + arrays[i] * arrays[k + 1] * arrays[j + 1])

print(dp[0][-1])