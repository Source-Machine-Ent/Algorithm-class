#20220505 1713.py
import sys
input = sys.stdin.readline

N = int(input()) #사진틀의 개수
M = int(input()) #전체 학생의 총 추천 횟수
dic = dict() 

#추천 받은 학생을 나타내는 번호
student = list(map(int, input().split()))

for i in range(M):
    if student[i] in dic:
        dic[student[i]][0] += 1
    else: 
        if len(dic) < N: #사진 틀이 비어있는 경우
            dic[student[i]] = [1, i]
        else: #사진 틀이 비어있지 않은 경우
            remove_list = sorted(dic.items(), key = lambda x: (x[1][0],x[1][1]))
            key = remove_list[0][0]
            del (dic[key])
            dic[student[i]] = [1, i]

result = list(sorted(dic.keys()))
for i in result:
    print(i, end=' ')

