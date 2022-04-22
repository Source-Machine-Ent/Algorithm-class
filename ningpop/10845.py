# 2022.04.22
# 풀이 시간 10분 00초
# 채점 결과: 정답
# 시간복잡도: O(1)
# 문제 링크: https://www.acmicpc.net/problem/10845

import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

q = deque()
for _ in range(n):
    order = input().strip()

    if order == 'pop':
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif order == 'size':
        print(len(q))
    elif order == 'empty':
        if q:
            print(0)
        else:
            print(1)
    elif order == 'front':
        if q:
            print(q[0])
        else:
            print(-1)
    elif order == 'back':
        if q:
            print(q[-1])
        else:
            print(-1)
    else:
        o, num = order.split()
        q.append(int(num))