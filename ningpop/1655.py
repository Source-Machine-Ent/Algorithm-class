# 2022.07.01
# 풀이 시간: 68분 40초
# 채점 결과: 시간 초과 -> 오답 -> 정답
# 시간복잡도: O(NlogNlogN)
# 문제 링크: https://www.acmicpc.net/problem/1655

import sys
import heapq

input = sys.stdin.readline

n = int(input())
left_heap = []
right_heap = []
for i in range(n):
    number = int(input())
    
    if len(left_heap) == len(right_heap):
        heapq.heappush(left_heap, -number)
    else:
        heapq.heappush(right_heap, number)
    
    if left_heap and right_heap:
        if -left_heap[0] > right_heap[0]:
            left = -heapq.heappop(left_heap)
            right = heapq.heappop(right_heap)
            heapq.heappush(left_heap, -right)
            heapq.heappush(right_heap, left)
    
    print(-left_heap[0])