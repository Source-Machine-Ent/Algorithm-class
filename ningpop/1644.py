# 2022.05.21
# 풀이 시간 37분 07초
# 채점 결과: 시간초과 -> 정답
# 시간복잡도: O(NloglogN)
# 문제 링크: https://www.acmicpc.net/problem/1644

import sys
import math

input = sys.stdin.readline

def is_prime_number(n):
    array = [True for i in range(n + 1)]

    for i in range(2, int(math.sqrt(n)) + 1):
        if array[i]:
            j = 2
            while i * j <= n:
                array[i * j] = False
                j += 1

    return [ i for i in range(2, n + 1) if array[i] ]

n = int(input())

array = is_prime_number(n)

count = 0
i = j = 0
while j <= len(array):
    result = sum(array[i:j])
    if result == n:
        count += 1
        j += 1
    elif result < n:
        j += 1
    elif result > n:
        i += 1
print(count)