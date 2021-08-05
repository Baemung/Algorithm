import sys
input = sys.stdin.readline

def GCD(a, b):
    while b:
        a, b = b, a%b
    return a

n = int(input())
li = list(map(int, input().split()))
for i in range(1,n):
    gcd = GCD(li[i], li[0])
    print("%d/%d"%(li[0]//gcd, li[i]//gcd))