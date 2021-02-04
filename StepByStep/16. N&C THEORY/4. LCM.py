import sys
input = sys.stdin.readline

def GCD(a, b):
    while(b): a,b = b,a%b
    return a

for i in range(int(input())):
    a,b = map(int, input().split())
    print(a*b//GCD(max(a,b),min(a,b)))