import sys
from collections import deque

r, c = map(int, sys.stdin.readline().split())
board = [list(sys.stdin.readline().rstrip()) for _ in range(r)]
visited = [[0]* c for _ in range(r)]

bx, by = 0, 0
wx, wy = 0, 0

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

queue = deque()

for i in range(r):
    for j in range(c):
        if board[i][j] == "S":
            queue.append((i, j))
    if 'D' in board[i]:
        rx = i
        ry = board[i].index('D')

for i in range(r):
    for j in range(c):
        if board[i][j] == "*":
            queue.append((i, j))

def bfs(rx, ry):
    while queue:
        px, py = queue.popleft()
        for i in range(4):            
            nx = px + dx[i]
            ny = py + dy[i]
            
            if 0<=nx<r and 0<=ny<c:
                if (board[nx][ny] == "." or board[nx][ny] == "D") and board[px][py] == "S":
                    if board[nx][ny] == "D":
                        return visited[px][py] + 1
                    board[nx][ny] = "S"
                    visited[nx][ny] = visited[px][py] + 1
                    queue.append((nx, ny))
                elif (board[nx][ny] == "." or board[nx][ny] == "S") and board[px][py] == "*":
                    board[nx][ny] = "*"                    
                    queue.append((nx, ny)) 
                    
        
    return "KAKTUS"

print(bfs(rx,ry))