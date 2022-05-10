# 2022.05.06
# 풀이 시간 분 초
# 채점 결과: 
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/2042

import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())
numbers = []
for _ in range(n):
    numbers.append(int(input()))
for _ in range(m + k):
    a, b, c = map(int, input().split())
    if a == 1: # b번째 수를 c로 바꾸기
        pass
    elif a == 2: # b번째 수부터 c번째 수까지 합 구하기
        pass
