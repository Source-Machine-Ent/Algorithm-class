#20220504 2579.py
import sys
input = sys.stdin.readline

N = int(input())
score = [0]

for _ in range(N):
    num = int(input())
    score.append(num)

if N == 1:
    print(score[1])
else:
    d = [0] * (N+1)
    d[1] = score[1]
    d[2] = score[1] + score[2]

    for i in range(3, N+1):
        d[i] = max(d[i-3] + score[i-1] + score[i], d[i-2] + score[i])

    print(d[N])