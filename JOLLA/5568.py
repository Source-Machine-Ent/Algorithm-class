#20220509 5568.py
from itertools import permutations
import sys
input = sys.stdin.readline

N, K = int(input()), int(input())
numbers = [input().rstrip() for _ in range(N)]
array= set()

for i in permutations(numbers, K):
    array.add(''.join(i))

print(len(array))