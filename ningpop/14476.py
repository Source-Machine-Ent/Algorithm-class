# 2022.04.24
# 풀이 시간 40분 00초
# 채점 결과: 메모리 초과 -> 시간 초과 -> 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/14476

import sys
from math import gcd

input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

left_gcd = [0] * len(numbers)
left_gcd[0] = numbers[0]
right_gcd = [0] * len(numbers)
right_gcd[-1] = numbers[-1]
for i in range(1, len(numbers)):
    left_gcd[i] = gcd(left_gcd[i - 1], numbers[i])
for i in range(len(numbers) - 2, -1, -1):
    right_gcd[i] = gcd(right_gcd[i + 1], numbers[i])

maximum = (-1, -1)
for i in range(len(numbers)):
    result = -1
    if i == 0:
        result = right_gcd[1]
    elif i == len(numbers) - 1:
        result = left_gcd[len(numbers) - 2]
    else:
        result = gcd(left_gcd[i - 1], right_gcd[i + 1])

    if numbers[i] % result == 0:
        continue
    
    if maximum[0] < result:
        maximum = (result, numbers[i])

if maximum == (-1, -1):
    print(-1)
else:
    print(*maximum)