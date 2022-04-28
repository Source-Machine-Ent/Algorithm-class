#20220426 1922.py

N = int(input())
M = int(input())
root = [i for i in range(N+1)]
edge = []
res = 0

def findroot(n):
    if root[n] != n:
        root[n] = findroot(root[n])
    return root[n]

for _ in range(M):
    a, b, c = map(int, input().split())
    edge.append((c, a, b))

edge.sort()
for c, a, b in edge:
    a_root = findroot(a)
    b_root = findroot(b)

    if a_root != b_root:
        res += c
        if a_root < b_root:
            root[b_root] = a_root
        else:
            root[a_root] = b_root


print(res)
