# 2022.04.20
# 풀이 시간 32분 00초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/11659

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
array = [0] + list(map(int, input().split()))

memo = [ 0 for _ in range(n + 1) ]
for i in range(1, n + 1):
    memo[i] = array[i] + memo[i - 1]

for _ in range(m):
    i, j = map(int, input().split())
    print(memo[j] - memo[i - 1])