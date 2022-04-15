"""
입력
입력은 기계 여러 대의 설명으로 이루어져 있다. 
각 기계의 설명은 프로그램과 입력영역으로 나누어져 있다.

프로그램은 명령어로 이루어져 있고, 명령어는 한 줄에 하나씩 있다. 각 명령은 문제 설명에 나와있는 대문자 알파벳 3글자이고, 다른 글자는 주어지지 않는다. 
NUM의 경우에는 명령어 다음에 숫자가 주어지며, 이 숫자는 0보다 크거나 같고, 109보다 작거나 같은 정수이다. 
NUM과 숫자는 공백으로 구분되어져 있다. 
각 프로그램은 END가 나오면 끝난다.

입력영역은 첫째 줄에 프로그램 수행 횟수 N이 있다. 
(0 ≤ N ≤ 10,000) 다음 N개의 줄에는 한 줄에 하나씩 입력값 Vi가 있다. 
(0 ≤ Vi ≤ 109) 각 입력값에 대해서 프로그램을 한 번씩 수행해야 하고, 이 수행은 모두 독립적이다. 
매번 프로그램을 수행할 때, 스택에 들어있는 값은 입력값 Vi 하나이다.

각각의 기계 설명은 빈 줄로 구분되어져 있다. 
QUIT이 나오면 다음 기계 설명이 없다는 뜻이다. 
명령어가 100,000개를 넘어가는 경우와 스택이 수행될 때, 1,000개 이상의 숫자를 저장하는 경우는 없다.

출력
각각의 입력값에 대해서, 해당하는 프로그램을 수행한뒤, 출력값을 출력하면 된다. 출력값이란 스택에저장되어있는 숫자이다.
만약, 프로그램 에러가 발생하거나, 모든 수행이 종료됏을 때 스택에 저장되어 있는 숫자가 1개가 아니라면, "ERROR"를 출력한다.
각 기계에 대한 출력값들을 모두 출력한 뒤에는 빈줄을 하나 출력해야 한다.
"""

import sys
from collections import deque

def calculate(cmd, num):
    MV = 10**9

    stack = deque([num])
    
    for i in cmd:

        if "NUM" in i:
            tmp = list(i.split())
            stack.append(int(tmp[-1]))

        elif not stack:
            return "ERROR"

        elif i == "POP":
            stack.pop()

        elif i == "INV":
            stack[-1] = -stack[-1]

        elif i == "DUP":
            stack.append(stack[-1])

        elif i == "SWP":
            stack[-1], stack[-2] = stack[-2], stack[-1]

        elif i == "ADD":
            tmp = stack.pop() + stack.pop()
            if tmp > MV:
                return "ERROR"
            stack.append(tmp)

        elif i == "SUB":
            tmp = -stack.pop() + stack.pop()
            if abs(tmp) > MV:
                return "ERROR"
            stack.append(tmp)

        elif i == "MUL":
            tmp = stack.pop() * stack.pop()
            if tmp > MV:
                return "ERROR"
            stack.append(tmp)

        elif i == "DIV":
            n = stack.pop()
            m = stack.pop()

            if n == 0:
                return "ERROR"

            tmp = abs(m) // abs(n)

            if (n>0 and m<0) or (n<0 and m>0):
                tmp  = -tmp

            if abs(tmp) > MV:
                return "ERROR"
            stack.append(tmp)

        elif i == "MOD":
            n = stack.pop()
            m = stack.pop()

            if n == 0:
                return "ERROR"

            tmp = abs(m) % abs(n)

            if (n < 0 or m < 0):
                tmp  = -tmp

            if abs(tmp) > MV:
                return "ERROR"
    
            stack.append(tmp)

    if len(stack) == 1:
        return stack[-1]
    return "ERROR"


while True:
    command = []
    
    while True:
        n = sys.stdin.readline().rstrip()
        if n == 'END':
            break
        if n == 'QUIT':
            quit()
            
        command.append(n)

    for _ in range(int(sys.stdin.readline())):
        tmp = int(sys.stdin.readline())
        print(calculate(command, tmp))

    print()
    input()
