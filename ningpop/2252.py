# 2022.04.19
# 풀이 시간 20분 00초
# 채점 결과: 정답
# 시간복잡도: O(N + M)
# 문제 링크: https://www.acmicpc.net/problem/2252

import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

indegree = [0] * (n + 1)
graph = [[] for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

def topology_sort():
    result = []
    q = deque()

    for i in range(1, n + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        result.append(now)

        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
        
    print(*result)

topology_sort()