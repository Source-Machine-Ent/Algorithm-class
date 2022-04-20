#20220420 11659.py
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))
num_list = [0]
total =0

for i in range(len(num)):
    total += num[i]
    num_list.append(total)

for _ in range(M):
    i, j = map(int, input().split())
    print(num_list[j] - num_list[i-1])

