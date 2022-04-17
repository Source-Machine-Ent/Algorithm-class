'''
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력
이항계수의 값을 출력한다.
'''

import sys
n, k= map(int, sys.stdin.readline().split())

# def factorial(n):
#     if n==1:
#         return 1
#     else:
#         return n * factorial(n-1)

def factorial(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

result = factorial(n)//(factorial(k) * factorial(n-k))

print(result)