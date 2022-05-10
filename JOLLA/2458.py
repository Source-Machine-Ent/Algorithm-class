#20220510 2458.py
import sys

N, M = map(int, input().split())
result = [[0 for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M):
    tall, short = map(int, sys.stdin.readline().split())
    result[tall][short] = 1

for p in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            #두 노드의 연결관계 확인
            if result[i][j] == 1 or (result[i][p] == 1 and result[p][j] == 1):
                result[i][j] = 1

cnt = 0
for i in range(1, N+1):
    temp_count = 0
    for j in range(1, N+1):
        temp_count += result[i][j] + result[j][i]
    if temp_count == N-1:
        cnt += 1

print(cnt)