#20220428 1062.py
import sys
input = sys.stdin.readline


N, K = map(int, input().split())
word = ['a', 'n', 't', 'i', 'c']
study_word = ['b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
              'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z']
sen = []

for _ in range(N):
    sen.append(input().strip())

def study(n, start):
    global res
    if n == 0:
        res = max(res, check())
        return 
    for i in range(start, len(study_word)):
        word.append(study_word[i])
        study(n-1, i+1)
        word.pop()
    

def check():
    res = 0
    for i in sen:
        flag = True
        for j in range(4, len(i)-4):
            if i[j] not in word:
                flag = False
                break
        if flag:
            res +=1
    return res

res = 0

if K < 5:
    print(res)
else:
    study(K-5, 0)
    print(res)
