from sys import stdin
import heapq as hq

input = stdin.readline

n = int(input())

heap = []
result = []
for _ in range(n):
    x = int(input())
    if x == 0:
        if not heap:
            print(0)
        else:
            value = -hq.heappop(heap)
            print(value)
        continue
    hq.heappush(heap, -x)



