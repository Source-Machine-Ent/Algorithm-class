# 2022.04.22
# 풀이 시간 265분 00초
# 채점 결과: 오답 -> 정답
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/3055

import sys
from collections import deque

input = sys.stdin.readline

r, c = map(int, input().split())

board = []
d = (-1, -1)
s = (-1, -1)
w = (-1, -1)
minute = 0
q = deque()
for i in range(r):
    row = list(input().strip())
    if 'D' in row:
        d = (i, row.index('D'))
    if 'S' in row:
        s = (i, row.index('S'))
    if '*' in row:
        w = (i, row.index('*'))
        q.append(('w', w[0], w[1], minute))
    board.append(row)

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

q.append(('s', s[0], s[1], minute))
is_escaped = False
while q:
    if is_escaped:
        minute = m + 1
        break
    who, x, y, m = q.popleft()
    if who == 'w':
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < r and 0 <= ny < c:
                if board[nx][ny] != 'X' and board[nx][ny] != 'D' and board[nx][ny] != '*':
                    board[nx][ny] = '*'
                    q.append(('w', nx, ny, m + 1))
    elif who == 's':
        if x == d[0] and y == d[1]:
            is_escaped = True
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < r and 0 <= ny < c:
                if board[nx][ny] == 'D':
                    is_escaped = True
                if board[nx][ny] == '.' or board[nx][ny] == 'D':
                    board[nx][ny] = m + 1
                    q.append(('s', nx, ny, m + 1))

if is_escaped:
    print(minute)
else:
    print('KAKTUS')