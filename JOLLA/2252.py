#20220419 2252.py
import queue
import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

key = []
graph = [[]for _ in range(N+1)]
degree = [0 for _ in range(N+1)]
queue = deque()

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    degree[B] += 1

for i in range(1, N+1):
    if degree[i] == 0:
        queue.append(i)

while queue:
    temp = queue.popleft()
    key.append(temp)
    for i in graph[temp]:
        degree[i] -= 1
        if degree[i] == 0:
            queue.append(i)

print(*key)