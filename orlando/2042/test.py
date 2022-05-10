'''
문제
어떤 N개의 수가 주어져 있다. 
그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 
만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다.
그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. 
M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 
그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 
그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, 
a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.

출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 
단, 정답은 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
'''
import sys

# 배열의 시작인덱스와 끝 인덱스를 시작으로 각 구간의 합을 트리에 추가한다.
# index는 세그먼트 트리의 인덱스이다.
def init(start, end, index):
    # 마지막까지 트리의 삽입이 끝났다면 반환
    if start == end:
        tree[index] = arr[start]
        return tree[index]

    mid = (start + end) // 2

    # 트리의 값을 추가한다.
    tree[index] = init(start, mid, index * 2) + init(mid + 1, end, index * 2 + 1)
    return tree[index]

def calc_sum(start, end, index, left, right):
    if left > end or right < start:
        return 0

    if left <= start and right >= end:
        return tree[index]

    mid = (start + end) // 2
    return calc_sum(start, mid, index * 2, left, right) + calc_sum(mid + 1, end, index * 2 +1, left, right )

def update(start, end, index, preLoc, nextVal):
    if preLoc < start or preLoc > end:
        return
    
    tree[index] += nextVal
    if start == end:
        return

    mid = (start + end) //2
    update(start, mid, index * 2 , preLoc, nextVal)
    update(mid + 1, end, index * 2 + 1 , preLoc, nextVal)

n, m, k = map(int, sys.stdin.readline().split())

arr = []
tree = [0] * (n * 4)

for _ in range(n):
    arr.append(int(sys.stdin.readline()))


init(0, n-1, 1)

for _ in range(m + k):
    a, b, c = map(int,sys.stdin.readline().split())
    if a == 1:
        b -= 1
        val = c - arr[b] 
        arr[b] = c
        update(0, n-1, 1, b, val)
        continue
    print(calc_sum(0, n-1, 1, b-1, c-1))
