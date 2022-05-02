# 2022.05.02
# 풀이 시간 62분 21초
# 채점 결과: 시간 초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/1256

import sys
from itertools import permutations

input = sys.stdin.readline

def get_count(n: int, m: int):
    if n == 0 and m == 0:
        return 0
    elif n == 0 or m == 0:
        return 1
    return get_count(n - 1, m) + get_count(n, m - 1)

n, m, k = map(int, input().split())

characters = ['a'] * n + ['z'] * m

if get_count(n, m) < k:
    print(-1)
else:
    result = sorted(list(set(permutations(characters, n + m))))
    print(''.join(result[k - 1]))