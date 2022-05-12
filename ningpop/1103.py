# 2022.05.12
# 풀이 시간 98분 47초
# 채점 결과: 오답 -> 시간초과 -> 런타임 에러 -> 정답
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/1103

import sys

sys.setrecursionlimit(100000)
input = sys.stdin.readline

def dfs(x: int, y: int, count: int) -> int:
    global is_visited, max_count
    max_count = max(max_count, count)

    for i in range(4):
        nx = x + (dx[i] * board[x][y])
        ny = y + (dy[i] * board[x][y])
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if board[nx][ny] == 'H':
            continue
        if is_visited[nx][ny]:
            print(-1)
            exit()
        if count + 1 <= dp[nx][ny]:
            continue
        
        dp[nx][ny] = count + 1
        is_visited[nx][ny] = True
        dfs(nx, ny, count + 1)
        is_visited[nx][ny] = False

n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append([ i if i.isalpha() else int(i) for i in list(input().rstrip()) ])

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

max_count = 0
is_visited = [ [False] * m for _ in range(n) ]
dp = [ [0] * m for _ in range(n) ]
dfs(0, 0, 0)
print(max_count + 1)