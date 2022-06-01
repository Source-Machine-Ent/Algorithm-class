# 2022.05.31
# 풀이 시간 5분 23초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/11653

import sys

input = sys.stdin.readline

n = int(input())
i = 2
while n > 1:
    if n % i == 0:
        print(i)
        n //= i
    else:
        i += 1