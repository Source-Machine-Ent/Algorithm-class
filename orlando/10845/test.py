import sys
from collections import deque

n = int(sys.stdin.readline())

queue = deque()

def calc(cmd):
    if "push" in cmd:
        num = int(list(map(str, cmd.split()))[1])
        queue.append(num)

    elif cmd == "pop":
        if not queue:
            print(-1)
        else:
            print(queue.popleft())

    elif cmd == "size":
        print(len(queue))

    elif cmd == "empty":
        if not queue:
            print(1)
        else:
            print(0)

    elif cmd == "front":
        if not queue:
            print(-1)
        else:
            print(queue[0])
            
    else:
        if not queue:
            print(-1)
        else:
            print(queue[-1])


for _ in range(n):
    calc(sys.stdin.readline().rstrip())
