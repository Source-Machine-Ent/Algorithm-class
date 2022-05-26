#20220526 1920.py
import sys

N = int(input())
N_list = set(map(int, input().split()))

M = int(input())
M_list = list(map(int, input().split()))

for i in M_list:
    print(1) if i in N_list else print(0)
