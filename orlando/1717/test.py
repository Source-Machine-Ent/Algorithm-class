'''
문제
초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다. 
여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.

집합을 표현하는 프로그램을 작성하시오.

입력
첫째 줄에 n(1 ≤ n ≤ 1,000,000), m(1 ≤ m ≤ 100,000)이 주어진다. 

m은 입력으로 주어지는 연산의 개수이다. 

다음 m개의 줄에는 각각의 연산이 주어진다. 

합집합은 0 a b의 형태로 입력이 주어진다.
이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.

두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 
이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. 
a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다.

출력
1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. 
(yes/no 를 출력해도 된다)
'''

import sys

n, m = map(int, sys.stdin.readline().split())
arr = [[] for i in range(n+1)]

for _ in range(m):
    num, a, b = map(int, sys.stdin.readline().split())
    if num == 0:
        for i in arr[a]:
            arr[b].append(i)
        for i in arr[b]:
            arr[a].append(i)
        continue
    
    if b in arr[a] and a in arr[b]:
        print("YES")
    else:
        print("NO")