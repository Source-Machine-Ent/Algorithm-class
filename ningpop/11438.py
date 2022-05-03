# 2022.05.03
# 풀이 시간 55분 30초
# 채점 결과: 메모리 초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/11438

import sys

input = sys.stdin.readline

n = int(input())
parent = [0] * (n + 1)
for _ in range(n - 1):
    u, v = map(int, input().split())
    if u > v:
        u, v = v, u
    parent[v] = u

m = int(input())
for _ in range(m):
    u, v = map(int, input().split())
    if u > v:
        u, v = v, u
    u_arr = [parent[u]]
    v_arr = [parent[v]]

    current_u = parent[u]
    while current_u != 1:
        current_u = parent[current_u]
        u_arr.append(current_u)
    
    current_v = parent[v]
    while current_v != 1:
        current_v = parent[current_v]
        v_arr.append(current_v)

    if u in v_arr:
        print(u)
        continue
    parent_node = 0
    while True:
        if (not u_arr) and (not v_arr):
            break
        if u_arr:
            u_node = u_arr.pop()
        if v_arr:
            v_node = v_arr.pop()
        if u_node == v_node:
            parent_node = u_node
    print(parent_node)