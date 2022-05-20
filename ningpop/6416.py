# 2022.05.20
# 풀이 시간 10분 00초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/6416

import sys

input = sys.stdin.readline

def is_tree(tree: list) -> bool:
    pass

case = 1
while True:
    tree = []
    while True:
        u, v = map(int, input().split())
        if u == -1 and v == -1:
            exit()
        if u == 0 and v == 0:
            break
    
    if is_tree(tree):
        print(f'Case {case} is a tree.')
    else:
        print(f'Case {case} is not a tree.')
    case += 1