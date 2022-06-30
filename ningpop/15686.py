# 2022.06.30
# 풀이 시간: 35분 14초
# 채점 결과: 정답
# 시간복잡도: O(N^3)
# 문제 링크: https://www.acmicpc.net/problem/15686

import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
chicken = []
house = []
for i in range(n):
    row = list(map(int, input().rstrip().split()))
    for j in range(n):
        if row[j] == 2:
            chicken.append((i, j))
        elif row[j] == 1:
            house.append((i, j))

chicken_length = 1e9
for case in list(combinations(chicken, m)):
    this_case_chicken_length = 0
    for hi, hj in house:
        curr_chicken_length = 1e9
        for ci, cj in case:
            curr_chicken_length = min(curr_chicken_length, abs(hi - ci) + abs(hj - cj))
        this_case_chicken_length += curr_chicken_length
    chicken_length = min(chicken_length, this_case_chicken_length)

print(chicken_length)