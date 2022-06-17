# 2022.06.16
# 풀이 시간 59분 04초
# 채점 결과: 시간초과 -> 정답
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/9252

import sys

input = sys.stdin.readline

first = input().rstrip()
second = input().rstrip()

row = len(second)
col = len(first)

dp = [ [0] * (col + 1) for _ in range(row + 1) ]
for i in range(1, row + 1):
    for j in range(1, col + 1):
        if first[j - 1] == second[i - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[-1][-1])
if dp[-1][-1] > 0:
    answer = ""
    i, j = row, col
    while dp[i][j] > 0:
        if dp[i - 1][j] == dp[i][j] - 1 and dp[i][j - 1] == dp[i][j] - 1:
            answer = first[j - 1] + answer
            i -= 1
            j -= 1
        else:
            if dp[i - 1][j] > dp[i][j - 1]:
                i -= 1
            else:
                j -= 1
    print(answer)