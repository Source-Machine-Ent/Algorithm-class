#20220511 1915.py
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
dp = [[0] * M for _ in range(N)]
square = []

for _ in range(N):
    square.append(list(map(int, list(input().rstrip()))))  

ans = 0
for i in range(N):
    for j in range(M):
        if i == 0 or j == 0:
            dp[i][j] = square[i][j]
        elif square[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1  
        
        ans = max(dp[i][j], ans)

print(ans*ans)
