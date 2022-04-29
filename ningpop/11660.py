# 2022.04.27
# 풀이 시간 52분 55초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(M*N^2)
# 문제 링크: https://www.acmicpc.net/problem/11660

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
array = [ [0] * (n + 1) ]
for _ in range(n):
    array.append([0] + list(map(int, input().split())))

data = [ [0] * (n + 1) for _ in range(n + 1) ]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        data[i][j] = data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1] + array[i][j]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    result = data[x2][y2] - data[x1 - 1][y2] - data[x2][y1 - 1] + data[x1 - 1][y1 - 1]
    print(result)