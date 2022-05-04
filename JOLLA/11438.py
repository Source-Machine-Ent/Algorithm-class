#20220503 11438.py
import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
LENGTH = 21

N = int(input())
parent = [[0]*LENGTH for _ in range(N+1)] #부모 노드
visited = [False] * (N+1) #깊이 계산 여부
d = [0] * (N+1) #깊이
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(x, depth):
    visited[x] = True
    d[x] =depth
    
    for i in range[x]:
        if visited[i]:
            continue
        parent[i][0] = x
        dfs(i, depth+1)

def set_parent():
    dfs(1, 0)
    for i in range(1, LENGTH):
        for j in range(1, N+1):
            parent[j][i] = parent[parent[j][i-1]][i-1]

def lca(a, b):
    if d[a] > d[b]:
        a, b = b, a

    for i in range(LENGTH - 1, -1, -1):
        if d[b] - d[a] >= 2**i:
            b = parent[b][i]

    if a == b:
        return a
    
    for i in range(LENGTH-1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    
    return parent[a][0]

set_parent()
M = int(input())

for _ in range(M):
    a, b = map(int, input().split())
    print(lca(a,b))