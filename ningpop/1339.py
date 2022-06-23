# 2022.06.23
# 풀이 시간 분 초
# 채점 결과: 오답
# 시간복잡도: 
# 문제 링크: https://www.acmicpc.net/problem/1339

import sys

input = sys.stdin.readline

n = int(input())
word = []
for _ in range(n):
    word.append(input().rstrip())

board = [ [0] * 8 for _ in range(n) ]
for i in range(n):
    space = 8 - len(word[i])
    for j in range(8):
        if j >= space:
            board[i][j] = word[i][j - space]

word_table = {}
number = 9
for j in range(8):
    for i in range(n):
        if board[i][j] == 0:
            continue
        if board[i][j] in word_table.keys():
            board[i][j] = word_table[board[i][j]]
        else:
            word_table[board[i][j]] = number
            board[i][j] = number
            number -= 1

result = 0
for i in range(n):
    num = ''
    for j in range(8):
        if board[i][j] == 0:
            continue
        num += str(board[i][j])
    result += int(num)
print(board)
print(result)