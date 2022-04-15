# 2022.04.15
# 풀이 시간 14분 26초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/10828

import sys
input = sys.stdin.readline

n = int(input())

stack = []
for _ in range(n):
    order = input()
    
    token = order[:3]
    if token == "pus":
        if order[3] == "h":
            value = int(order.split()[1])
            stack.append(value)
    elif token == "pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif token == "siz":
        if order[3] == "e":
            print(len(stack))
    elif token == "emp":
        if order[3:5] == "ty":
            if stack:
                print(0)
            else:
                print(1)
    elif token == "top":
        if stack:
            print(stack[-1])
        else:
            print(-1)
    else:
        continue
