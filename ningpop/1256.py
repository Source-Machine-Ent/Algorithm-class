# 2022.05.02
# 풀이 시간 102분 37초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(N*M*logN)
# 문제 링크: https://www.acmicpc.net/problem/1256

import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())

word_count = [ [1] * (m + 1) for _ in range(n + 1) ]
word_count[0][0] = 0

for i in range(1, n + 1):
    for j in range(1, m + 1):
        word_count[i][j] = word_count[i][j - 1] + word_count[i - 1][j]

if word_count[n][m] < k:
    print(-1)
else:
    result = ''
    while True:
        if n == 0 or m == 0:
            result += 'a'*n
            result += 'z'*m
            break
        a_selected = word_count[n - 1][m]

        if k <= a_selected:
            result += 'a'
            n -= 1
        else:
            result += 'z'
            m -= 1
            k -= a_selected
    print(result)