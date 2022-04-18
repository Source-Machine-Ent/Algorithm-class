# 2022.04.18
# 풀이 시간 15분 45초
# 채점 결과: 정답
# 시간복잡도: O(2^N)
# 문제 링크: https://www.acmicpc.net/problem/11051

import sys

input = sys.stdin.readline

def factorial(n: int) -> int:
    if n == 0:
        return 1
    if n <= 2:
        return n
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

n, k = map(int, input().split())

result = factorial(n) // (factorial(n - k) * factorial(k))
print(int(result % 10007))