#20220527 5639.py
import sys
sys.setrecursionlimit(10 ** 6)
 
preorder = []

def postorder(start, end):
    
    if start > end:
        return
    
    root = preorder[start]
    idx = start + 1
 
    while idx <= end:
        if preorder[idx] > root:
            break
        idx += 1
    
    postorder(start +1 , idx-1)
    postorder(idx, end)
    print(root)
 
while True:
    try:
        preorder.append(int(sys.stdin.readline()))
    except:
        break

postorder(0, len(preorder) - 1)