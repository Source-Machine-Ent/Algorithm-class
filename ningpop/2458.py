# 2022.05.10
# 풀이 시간 38분 00초
# 채점 결과: 시간초과(Python3), 정답(Pypy3)
# 시간복잡도: O(N^3)
# 문제 링크: https://www.acmicpc.net/problem/2458

import sys

input = sys.stdin.readline
INF = 1E9

n, m = map(int, input().split())
graph = [ [INF] * (n + 1) for _ in range(n + 1) ]

for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

for _ in range(m):
    a, b = map(int, input().split())
    if graph[a][b] == INF:
        graph[a][b] = 0
    else:
        graph[a][b] += 1

for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer_array = [ i for i in range(1, n + 1) ]
result = 0
for i in range(1, n + 1):
    array = set()
    for j in range(1, n + 1):
        if graph[i][j] != INF:
            array.add(j)
    for j in range(1, n + 1):
        if graph[j][i] != INF:
            array.add(j)
    if sorted(list(array)) == answer_array:
        result += 1

print(result)