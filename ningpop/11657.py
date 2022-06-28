# 2022.06.28
# 풀이 시간: 39분 42초
# 채점 결과: 정답
# 시간복잡도: O(NM)
# 문제 링크: https://www.acmicpc.net/problem/11657

import sys

input = sys.stdin.readline
INF = int(1e9)

def bellman_ford(start):
    distance[start] = 0
    for i in range(n):
        for j in range(m):
            cur = edges[j][0]
            next_node = edges[j][1]
            cost = edges[j][2]
            if distance[cur] != INF and distance[next_node] > distance[cur] + cost:
                distance[next_node] = distance[cur] + cost
                if i == n - 1:
                    return True
    return False

n, m = map(int, input().rstrip().split())

edges = []
distance = [INF] * (n + 1)
for _ in range(m):
    a, b, c = map(int, input().rstrip().split())
    edges.append((a, b, c))

is_cycled = bellman_ford(1)
if is_cycled:
    print(-1)
else:
    for i in range(2, n + 1):
        if distance[i] == INF:
            print(-1)
        else:
            print(distance[i])