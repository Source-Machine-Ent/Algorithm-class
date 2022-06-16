# 2022.06.16
# 풀이 시간 32분 36초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/9252

import sys

input = sys.stdin.readline

first = input().rstrip()
second = input().rstrip()

row = len(second)
col = len(first)

dp = [ [0] * col for _ in range(row) ]
result = 0
idx = (0, 0)
for i in range(row):
    for j in range(col):
        if first[j] == second[i]:
            maximum = 0
            for k in range(i):
                for l in range(j):
                    if dp[k][l] > 0:
                        maximum = max(maximum, dp[k][l])
            dp[i][j] = maximum + 1
            if result < dp[i][j]:
                result = max(result, dp[i][j])
                idx = (i, j)

if result == 0:
    print(0)
else:
    print(result)
    for i in range(idx[1] + 1):
        for j in range(idx[0], -1, -1):
            if dp[j][i] > 0:
                print(first[i], end='')
                break
