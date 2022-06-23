# 2022.06.23
# 풀이 시간 분 초
# 채점 결과: 오답 -> 시간 초과
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/1339

import sys
from collections import defaultdict
from itertools import permutations

input = sys.stdin.readline

n = int(input())
words = []
for _ in range(n):
    words.append(input().rstrip())

char = []
for word in words:
    for c in word:
        if c not in char:
            char.append(c)

answer = 0
for case in list(permutations(char, len(char))):
    number = 9
    table = defaultdict(int)
    for c in case:
        table[c] = number
        number -= 1
    
    result = 0
    for word in words:
        num = ''
        for c in word:
            num += str(table[c])
        result += int(num)
    answer = max(answer, result)

print(answer)