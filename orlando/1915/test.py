'''
n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.

0	1	0	0
0	1	1	1
1	1	1	0
0	0	1	0
위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다. 

입력
첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

출력
첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.
'''

import sys

n, m = map(int, sys.stdin.readline().split())

graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]

result = 0
for i in range(n):
    for j in range(m):
        if i > 0 and j > 0 and graph[i][j] == 1:
            graph[i][j] += min(graph[i][j-1], graph[i-1][j], graph[i-1][j-1])
        result = max(result, graph[i][j])

print(result*result)