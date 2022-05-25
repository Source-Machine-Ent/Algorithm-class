# 2022.05.24
# 풀이 시간 60분 00초
# 채점 결과: 시간초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/5573

import sys

input = sys.stdin.readline

h, w, n = map(int, input().split())

board = [ [2] * w ]
for _ in range(h):
    board.append([2] + list(map(int, input().rstrip().split())))

i, j = 1, 1
for case in range(n):
    i, j = 1, 1
    while (0 < i < h + 1) and (0 < j < w + 1):
        if board[i][j] == 0:
            board[i][j] = 1
            i += 1
        elif board[i][j] == 1:
            board[i][j] = 0
            j += 1
print(i, j)