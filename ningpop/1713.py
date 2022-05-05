# 2022.05.05
# 풀이 시간 38분 28초
# 채점 결과: 오답 -> 정답
# 시간복잡도: O(N*M)
# 문제 링크: https://www.acmicpc.net/problem/1713

import sys

input = sys.stdin.readline

def is_candidate(student: int):
    for idx, value in enumerate(photo_case):
        if value[0] == student:
            return idx
    return False

n = int(input())
t = int(input())
recommend = list(map(int, input().split()))

photo_case = []
for i in range(t):
    value = is_candidate(recommend[i])
    if value is False: # 현재 후보가 아니라면
        if len(photo_case) == n: # 사진틀이 모두 꽉차있다면
            photo_case.pop()
        photo_case.append((recommend[i], 1, i))
    else: # 이미 후보라면
        photo_case[value] = (recommend[i], photo_case[value][1] + 1, photo_case[value][2])

    photo_case.sort(key=lambda x : (-x[1], -x[2]))

result = []
for candidate in photo_case:
    result.append(candidate[0])
result.sort()

print(*result)