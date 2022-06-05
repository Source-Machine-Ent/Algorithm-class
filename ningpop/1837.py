# 2022.06.05
# 풀이 시간 48분 38초
# 채점 결과: 메모리 초과 -> 시간 초과 -> 정답
# 시간복잡도: O(NloglogN)
# 문제 링크: https://www.acmicpc.net/problem/1837

import sys, math

input = sys.stdin.readline

def get_prime_number(n):
    array = [True for i in range(n + 1)]

    for i in range(2, int(math.sqrt(n)) + 1):
        if array[i]:
            j = 2
            while i * j <= n:
                array[i * j] = False
                j += 1

    return [ i for i in range(2, n + 1) if array[i] ]

P, k = map(int, input().split())

prime_numbers = get_prime_number(k)

for i in prime_numbers:
    if P % i == 0 and i < k:
        print('BAD', i)
        exit()

print('GOOD')