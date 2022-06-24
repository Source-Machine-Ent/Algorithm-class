# 2022.06.23
# 풀이 시간 65분 46초
# 채점 결과: 오답 -> 시간 초과 -> 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/1339

import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())
words = []
for _ in range(n):
    words.append(input().rstrip())

frequency = defaultdict(int)
for word in words:
    length = len(word) - 1
    for c in word:
        frequency[c] += pow(10, length)
        length -= 1

result = 0
number = 9
for key, value in sorted(frequency.items(), key=lambda x : -x[1]):
    result += (value * number)
    number -= 1

print(result)