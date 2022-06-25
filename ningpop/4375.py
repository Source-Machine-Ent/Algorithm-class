# 2022.06.25
# 풀이 시간 14분 19초
# 채점 결과: 정답
# 시간복잡도: O(loglogN)
# 문제 링크: https://www.acmicpc.net/problem/4375

import sys

input = sys.stdin.readline

while True:
    try:
        n = int(input())
        target = '1'
        while True:
            if n > int(target):
                target += '1'
                continue
            if int(target) % n == 0:
                break
            else:
                target += '1'
        print(len(target))
    except:
        break