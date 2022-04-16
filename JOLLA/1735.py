#20220416 1753.py

def gcd(a, b):
    n = a % b 
    while n>0:
        a = b
        b = n
        n = a % b
    return b

a, b = map(int(input().split()))
c, d = map(int(input().split()))

n = gcd(a*d + b*c, b*d)
print((a*d+c*b)//n, b*d//n)
