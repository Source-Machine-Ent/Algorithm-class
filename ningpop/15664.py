# 2022.06.27
# 풀이 시간: 07분 06초
# 채점 결과: 정답
# 시간복잡도: O(N!)
# 문제 링크: https://www.acmicpc.net/problem/15664

import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
numbers = list(map(int, input().rstrip().split()))

for num in sorted(list(set(permutations(numbers, m)))):
    if list(num) == sorted(num):
        print(*num)