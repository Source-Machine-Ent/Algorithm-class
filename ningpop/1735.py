# 2022.04.16
# 풀이 시간 40분 00초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(logN)
# 문제 링크: https://www.acmicpc.net/problem/1735

import sys

input = sys.stdin.readline

def gcd(a: int, b: int):
    while a > 0:
        temp = b
        b = a
        a = temp % a
    return b

x_a, x_b = map(int, input().split())
y_a, y_b = map(int, input().split())

a = 0
b = 0
if x_b % x_a == 0: # 첫번째 분수를 기약분수로 만들고 시작
    x_b //= x_a
    x_a = 1
if y_b % y_a == 0: # 두번째 분수를 기약분수로 만들고 시작
    y_b //= y_a
    y_a = 1

if x_b == y_b: # 분모가 같다면 분자만 계산
    a = x_a + y_a
    b = x_b
else: # 분모가 다르다면 분수 덧셈
    a = (x_a * y_b) + (x_b * y_a)
    b = x_b * y_b

value = gcd(a, b) # 약분을 시자아아아아아아아아아아아아아악~ 하겠습니다!!!!

print(a//value, b//value)