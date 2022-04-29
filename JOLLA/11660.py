#20220427 11660.py
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [[0]*(N+1)] + [[0] + list(map(int, input().split())) for _ in range(N)]

for i in range(1, N+1):
    for j in range(1, N+1):
        board[i][j] = board[i][j] + board[i-1][j]+board[i][j-1]-board[i-1][j-1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(board[x2][y2]-board[x1-1][y2]-board[x2][y1-1]+board[x1-1][y1-1])