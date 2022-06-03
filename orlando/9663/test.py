'''
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
'''

import sys

n = int(sys.stdin.readline())

board = [0] * n
result = 0
def promising(idx):
    for i in range(idx):
        if board[idx] == board[i] or abs(board[idx] - board[i]) == abs(idx - i):
            return False
    
    return True


def dfs(idx):
    if idx == n:
        global result
        result += 1
        return
    
    for i in range(n):
        board[idx] = i
        if promising(idx):
            dfs(idx + 1)

dfs(0)
print(result)