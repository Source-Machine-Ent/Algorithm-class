#20220531 5557.py

N = int(input())
num_list = list(map(int, input().split()))

dp = []
for i in range(N-1):
    dp.append([0 for _ in range(21)])

dp[0][num_list[0]] = 1
for i in range(1, N-1):
    for j in range(21):
        if dp[i-1][j]:
            if j + num_list[i] <= 20: dp[i][j + num_list[i]] += dp[i-1][j]
            if j - num_list[i] >= 0: dp[i][j - num_list[i]] += dp[i-1][j]

print(dp[N-2][num_list[N-1]])