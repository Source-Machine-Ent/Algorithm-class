# 2022.05.27
# 풀이 시간 64분 54초
# 채점 결과: 시간 초과 -> 정답
# 시간복잡도: O(N^2)
# 문제 링크: https://www.acmicpc.net/problem/5639

import sys

input = sys.stdin.readline

''' 시간 초과 코드 '''
# class Node:
#     def __init__(self, data):
#         self.left = None
#         self.right = None
#         self.data = data
    
# def postorder(node):
#     if node:
#         postorder(node.left)
#         postorder(node.right)
#         print(node.data)

# tree = [ Node(int(input())) ]

# while True:
#     try:
#         current_node = Node(int(input()))
#         tree.append(current_node)
#         node = tree[0]
#         while True:
#             if current_node.data > node.data:
#                 if node.right == None:
#                     node.right = current_node
#                     break
#                 else:
#                     node = node.right
#             elif current_node.data < node.data:
#                 if node.left == None:
#                     node.left = current_node
#                     break
#                 else:
#                     node = node.left
#     except:
#         break

# postorder(tree[0])

''' 정답 코드 '''
sys.setrecursionlimit(10 ** 9)

def postorder(start, end):
    if start > end:
        return
    
    div = end + 1
    for i in range(start + 1, end + 1):
        if tree[start] < tree[i]:
            div = i
            break
    
    postorder(start + 1, div - 1)
    postorder(div, end)
    print(tree[start])

tree = []
while True:
    try:
        tree.append(int(input()))
    except:
        break

postorder(0, len(tree) - 1)