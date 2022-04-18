#20220418 11051.py
import sys
from math import factorial

input = sys.stdin.readline
a, b = map(int, input().split())
n = factorial(a) // (factorial(b)*factorial(a-b))
print(n%10007)