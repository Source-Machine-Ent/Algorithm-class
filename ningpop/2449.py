# 2022.06.29
# 풀이 시간: 60분 40초
# 채점 결과: 미해결
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/2449

import sys

input = sys.stdin.readline

def change():
    pass

n, k = map(int, input().rstrip().split())
lights = list(map(int, input().rstrip().split()))

dp = [ [20] * 201 for _ in range(201) ]
