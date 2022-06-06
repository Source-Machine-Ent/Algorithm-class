# 2022.06.06
# 풀이 시간 21분 32초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/4358

import sys

input = sys.stdin.readline

forest = {}
result = 0

while True:
    tree = input().rstrip()
    if not tree:
        break
    result += 1
    if tree in forest.keys():
        forest[tree] += 1
    else:
        forest[tree] = 1

tree_list = sorted(forest.keys())

for tree_name in tree_list:
    print("%s %.4f" % (tree_name, forest[tree_name] * 100 / result))