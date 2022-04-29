# 2022.04.29
# 풀이 시간 23분 39초
# 채점 결과: 정답
# 시간복잡도: O(N)
# 문제 링크: https://www.acmicpc.net/problem/1991

import sys

input = sys.stdin.readline

class Node:
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
    
def preorder(node):
    if node:
        print(node.data, end='')
        preorder(node.left)
        preorder(node.right)

def inorder(node):
    if node:
        inorder(node.left)
        print(node.data, end='')
        inorder(node.right)

def postorder(node):
    if node:
        postorder(node.left)
        postorder(node.right)
        print(node.data, end='')

n = int(input())
nodes = [ Node(chr(i)) for i in range(65, 65 + n) ]
for _ in range(n):
    this, left, right = input().split()
    if left != '.':
        nodes[ord(this) - 65].left = nodes[ord(left) - 65]
    if right != '.':
        nodes[ord(this) - 65].right = nodes[ord(right) - 65]

preorder(nodes[0])
print()
inorder(nodes[0])
print()
postorder(nodes[0])