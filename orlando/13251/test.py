'''
문제
효빈이의 비밀 박스에는 조약돌이 N개 들어있다. 조약돌의 색상은 1부터 M까지 중의 하나이다.

비밀 박스에서 조약돌을 랜덤하게 K개 뽑았을 때, 뽑은 조약돌이 모두 같은 색일 확률을 구하는 프로그램을 작성하시오. 

입력
첫째 줄에 M (1 ≤ M ≤ 50)이 주어진다.

둘째 줄에는 각 색상의 조약돌이 몇 개 있는지 주어진다. 각 색상의 조약돌 개수는 1보다 크거나 같고 50보다 작거나 같은 자연수이다.

셋째 줄에는 K가 주어진다. (1 ≤ K ≤ N)

출력
첫째 줄에 뽑은 조약돌이 모두 같은 색일 확률을 출력한다. 정답과의 절대/상대 오차는 10-9까지 허용한다.
'''

import sys
import math

m = int(sys.stdin.readline())

stone = list(map(int, sys.stdin.readline().split()))

k = int(sys.stdin.readline())

stoneSum = sum(stone)


sameTotal = 0
for s in stone:
    sameTotal += math.comb(s, k)

total = math.comb(stoneSum, k)

result = sameTotal/total

print(result)