#20220414 3425.py

import sys

input = sys.stdin.readline

def run(command, num):
    stack = [num]
    for cmd in command:
        if cmd[:3] == "NUM":
            n = int(cmd[4:])
            stack.append(n)
        elif not stack:
            return "ERROR"
        elif cmd == "POP":
            stack.pop()
        elif cmd == "INV":
            stack[-1] *= -1
        elif cmd == "DUP":
            stack.append(stack[-1])
        elif len(stack) ==1:
            return "ERROR"
        elif cmd == "SWP":
            stack[-1], stack[-2] = stack[-2], stack[-1]
        elif cmd == "ADD":
            temp = stack.pop() + stack.pop()
            if abs(temp) > 10 ** 9:
                return "ERROR"
            stack.append(temp)
        elif cmd == "SUB":
            temp = -stack.pop() + stack.pop()
            if abs(temp) > 10**9:
                return "ERROR"
            stack.append(temp)
        elif cmd == "MUL":
            temp = stack.pop() * stack.pop()
            if abs(temp) > 10**9:
                return "ERROR"
            stack.append(temp)
        elif cmd == "DIV":
            a, b = stack.pop(), stack.pop()
            if a == 0:
                return "ERROR"
            temp = abs(b) // abs(a)
            if (a>0 and b<0) or (a<0 and b>0):
                temp = -temp
            if abs(temp) > 10**9:
                return "ERROR"
            stack.append(temp)
        elif cmd == "MOD":
            a, b = stack.pop(), stack.pop()
            if a == 0:
                return "ERROR"
            temp = abs(b) % abs(a)
            if b < 0:
                temp = -temp
            if abs(temp) > 10**9:
                return "ERROR"
            stack.append(temp)
        else:
            return "ERROR"
    
    if len(stack) == 1:
        return stack[0]
    return "ERROR"


while True:
    command = []
    while True:
        cmd = input().strip()
        if cmd == "QUIT":
            quit()
        if cmd == "END":
            break
        command.append(cmd)

    n = int(input())

    for _ in range(n):
        num = int(input())
        print(run(command, num))
    ß
    print()
    input()



