# 2022.05.03
# 풀이 시간 55분 30초
# 채점 결과: 메모리 초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/11438

import sys

input = sys.stdin.readline

n = int(input())
parent = [0] * (n + 1)
tree = [ [0] * (n + 1) for _ in range(n) ]
for _ in range(n - 1):
    u, v = map(int, input().split())
    if u > v:
        u, v = v, u
    tree[0][v] = u

for i in range(n + 1):
    j = 0
    while tree[j][i] > 1:
        node = tree[j][i]
        tree[j + 1][i] = tree[0][node]
        j += 1

# for i in range(n):
#     for j in range(n + 1):
#         print(tree[i][j], end='\t')
#     print()

m = int(input())
for _ in range(m):
    u, v = map(int, input().split())
    if u > v:
        u, v = v, u
    u_arr = []
    v_arr = []
    i = 0
    while tree[i][u] != 0:
        u_arr.append(tree[i][u])
        i += 1
    i = 0
    while tree[i][v] != 0:
        v_arr.append(tree[i][v])
        i += 1
    
    if u in v_arr:
        print(u)
        continue
    parent = 0
    while True:
        if (not u_arr) and (not v_arr):
            break
        if u_arr:
            u_node = u_arr.pop()
        if v_arr:
            v_node = v_arr.pop()
        if u_node == v_node:
            parent = u_node
    print(parent)