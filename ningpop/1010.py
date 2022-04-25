# 2022.04.25
# 풀이 시간 31분 55초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(2^N)
# 문제 링크: https://www.acmicpc.net/problem/1010

import sys

input = sys.stdin.readline

def factorial(n: int) -> int:
    global memo
    if memo[n] != 0:
        return memo[n]
    
    for i in range(n - 1, 0, -1):
        if memo[i] != 0:
            for j in range(i + 1, n + 1):
                memo[j] = memo[j - 1] * j
            break
    return memo[n]

t = int(input())
memo = [0] * 30
memo[0] = 1
memo[1] = 1
for _ in range(t):
    n, m = map(int, input().split())
    result = factorial(m) // (factorial(m - n) * factorial(n))
    print(result)