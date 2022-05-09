# 2022.05.09
# 풀이 시간 9분 51초
# 채점 결과: 정답
# 시간복잡도: O(N!)
# 문제 링크: https://www.acmicpc.net/problem/5568

import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
k = int(input())
numbers = []
for _ in range(n):
    numbers.append(input().rstrip())

cases = list(permutations(numbers, k))
result = set()
for num in cases:
    result.add(''.join(num))
print(len(result))