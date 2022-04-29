# 2022.04.28
# 풀이 시간 92분 48초
# 채점 결과: 시간 초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/1062

import sys
from itertools import combinations

input = sys.stdin.readline

n, k = map(int, input().split())
words = []
for _ in range(n):
    words.append(input().rstrip())

if k < 5:
    print(0)
else:
    leared_bit = ['0'] * 26
    for c in ['a', 'c', 'i', 'n', 't']:
        leared_bit[ord(c) - 97] = '1'
    leared_bit = bin(''.join(leared_bit))
    print(leared_bit)