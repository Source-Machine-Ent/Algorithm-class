import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

indegree = [0] * (n + 1)
graph = [[]for i in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

    indegree[b] += 1



def topology_sort():
    result = []
    queue = deque()

    for i in range(1, n + 1):
        if indegree[i] == 0:
            queue.append(i)

    while queue:

        now = queue.popleft()
        result.append(now)

        for i in graph[now]:
            indegree[i] -= 1

            if indegree[i] == 0:
                queue.append(i)

    for i in result:
        print(i, end=' ')

topology_sort()
