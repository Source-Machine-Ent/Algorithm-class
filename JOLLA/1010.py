#20220425 1010.py

def factorial(n):
    num = 1
    for i in range(1, n+1):
        num *= i
    return num

T = int(input())

for i in range(T):
    N, M = map(int, input().split())
    num = factorial(M) // (factorial(N)*factorial(M-N))
    print(num)
