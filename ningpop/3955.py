# 2022.05.02
# 풀이 시간 분 초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/3955

import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k, c = map(int, input().split())
    possible = False
    people = 0
    for i in range(int(1e9)):
        if (k * i + 1) % c == 0:
            possible = True
            people = i
            break
    if possible:
        print((k * people + 1) // c)
    else:
        print('IMPOSSIBLE')