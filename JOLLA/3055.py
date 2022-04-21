#20220421 3055.py
import queue
from collections import deque
import sys

R, C = map(int, input().split())
route = [list(p for p in sys.stdin.readline().strip()) for _ in range(R)]
queue = deque()

visited = [[0]*C for _ in range(R)]
DR = [1, 0, -1, 0]
DC = [0, -1, 0, 1]

for i in range(R):
    for j in range(C):
        if route[i][j] == '*':
            queue.append([i, j])
        elif route[i][j] =='S':
            queue.appendleft([i, j])
        elif route[i][j] =='D':
            dest_r = i
            dest_c = j

flag = False
while queue:
    if flag:
        break
    now_r, now_c = queue.popleft()

    for i in range(4):
        pre_r, pre_c = now_r + DR[i], now_c + DR[i]
        if pre_c<0 or pre_c>=C or pre_r<0 or pre_r>=R:
            continue

        if route[now_r][now_c]=='*':
            if route[pre_r][pre_c]=='.' or route[pre_r][pre_c]=='S':
                route[pre_r][pre_c] = '*'
                queue.append([pre_r, pre_c])

        elif route[now_r][now_c] == 'S':
            if route[pre_r][pre_c] == '.':
                route[pre_r][pre_c] = 'S'
                visited[pre_r][pre_c] = visited[now_r][now_c] + 1
                queue.append([pre_r, pre_c])
            elif route[pre_r][pre_c] == 'D':
                flag = True
                visited[pre_r][pre_c] = visited[now_r][now_c] + 1
                break

if visited[dest_r][dest_c] == 0:
    print('KAKTUS')
else:
    print(visited[dest_r][dest_c])


    