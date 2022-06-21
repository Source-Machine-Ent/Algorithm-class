# 2022.06.21
# 풀이 시간: 05분 58초
# 채점 결과: 정답
# 시간복잡도: O(NlogN)
# 문제 링크: https://www.acmicpc.net/problem/1927

import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    x = int(input())
    if x > 0:
        heapq.heappush(heap, x)
    else:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap))