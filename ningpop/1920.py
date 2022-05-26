# 2022.05.26
# 풀이 시간 15분 18초
# 채점 결과: 시간초과 -> 정답
# 시간복잡도: O(logN)
# 문제 링크: https://www.acmicpc.net/problem/1920

import sys

input = sys.stdin.readline

n = int(input())
numbers = sorted(list(map(int, input().rstrip().split())))

m = int(input())
for number in list(map(int, input().rstrip().split())):
    start = 0
    end = len(numbers) - 1
    center = (start + end) // 2
    is_find = False

    while start <= end:
        center = (start + end) // 2
        if number == numbers[center]:
            is_find = True
            break
        elif number < numbers[center]:
            end = center - 1
        else:
            start = center + 1
    
    if is_find:
        print(1)
    else:
        print(0)