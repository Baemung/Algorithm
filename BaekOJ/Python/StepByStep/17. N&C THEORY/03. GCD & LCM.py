import sys
input = sys.stdin.readline

def GCD(a, b):
    while b:
        a, b = b, a%b
    return a

a,b = map(int, input().split())
print(GCD(a, b), (a*b)//GCD(a, b), sep='\n')