import sys
input = sys.stdin.readline

def multiple(a, b, c):
    if b == 1:
        return a%c
    tmp = multiple(a, b//2, c)
    if b%2 == 0:
        return tmp**2 % c
    else:
        return a * tmp**2 % c

A,B,C = map(int, input().split())
print(multiple(A,B,C))