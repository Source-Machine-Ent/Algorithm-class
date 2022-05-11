# 2022.05.11
# 풀이 시간 39분 41초
# 채점 결과: 시간초과 -> 오답 -> 정답
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/1915

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
array = []
for _ in range(n):
    array.append(list(map(int, input().rstrip())))

maximum = 0
dp = [ [0] * m for _ in range(n) ]
for i in range(n):
    for j in range(m):
        if i == 0 or j == 0:
            dp[i][j] = array[i][j]
        elif array[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        maximum = max(maximum, dp[i][j])

print(maximum ** 2)