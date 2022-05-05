# 2022.05.05
# 풀이 시간 47분 43초
# 채점 결과: 런타임 에러 -> 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/2579

import sys

input = sys.stdin.readline

n = int(input())
stairs = []
for _ in range(n):
    stairs.append(int(input()))

if n == 1:
    print(stairs[-1])
else:
    dp = [0] * n
    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1]
    for i in range(2, n):
        dp[i] = max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]

    print(dp[-1])