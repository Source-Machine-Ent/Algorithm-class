# 2022.06.21
# 풀이 시간 51분 33초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(NlogN)
# 문제 링크: https://www.acmicpc.net/problem/2725

import sys

input = sys.stdin.readline

def gcd(a: int, b: int):
    while a > 0:
        temp = b
        b = a
        a = temp % a
    return b

case = int(input())
result = [ 0 for _ in range(1001) ]
for c in range(1, 1001):
    count = 0
    for h in range(c + 1):
        if gcd(h, c) == 1:
            count += 1
    for v in range(c):
        if gcd(c, v) == 1:
            count += 1
    result[c] = result[c - 1] + count

for _ in range(case):
    n = int(input())
    print(result[n])