# 2022.06.14
# 풀이 시간 13분 55초
# 채점 결과: 정답
# 시간복잡도: O(N*K)
# 문제 링크: https://www.acmicpc.net/problem/13251

import sys

input = sys.stdin.readline

m = int(input())
colors = list(map(int, input().rstrip().split()))
k = int(input())

total = sum(colors)
result = 0
for color in colors:
    same_color_case = 1
    for i in range(k):
        same_color_case *= (color - i) / (total - i)
    result += same_color_case
print(result)