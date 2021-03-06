'''
문제
N개의 도시가 있다. 
그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다. 
각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다. 
시간 C가 양수가 아닌 경우가 있다. 
C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.

1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다. 
둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다. 

출력
만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다. 
그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다. 
만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
'''
from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]

INF = int(1e9)

dis = [INF] * (n + 1)

# 벨만 포드 알고리즘
def belman_ford(start):
    # 시작 노드 0으로 초기화
    dis[start] = 0 
    # 정점 수 만큼 반복
    for i in range(n):
        for j in range(m): #-> 반복마다 모든 간선을 확인한다.
            node = arr[j][0] #-> 시작 노드
            next_node = arr[j][1] #-> 목표 노드
            cost = arr[j][2] #-> 목표 노드로 가는 비용

            # 갈수 있는 노드이며/ 현재 노드를 통해 가는 비용이 더 작을 경우
            if dis[node] != INF and dis[next_node] > dis[node] + cost:
                dis[next_node] = dis[node] + cost
                # n번째 라운드에서도 값이 갱신된다면 음수가 존재하는 것
                if i == n-1:
                    return True
    return False

negative_cycle = belman_ford(1)

if negative_cycle:
    print(-1)
else:
    for i in range(2, n+1): #-> 1번 노드를 제외한 다른 모든 노드를 가기위한 최단 거리 출력
        if dis[i] == True: #-> 도달 불가능 할 경우
            print(-1)
        else:
            print(dis[i]) #-> 거리 출력

