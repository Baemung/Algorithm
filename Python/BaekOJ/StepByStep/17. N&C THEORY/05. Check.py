import sys
input = sys.stdin.readline

def GCD(a, b):
    while b:
        a, b = b, a%b
    return a

def check(li):
    gcd, *li = li[1:]
    for num in li:
        gcd = GCD(gcd, num)
    for i in range(2, gcd//2+1):
        if gcd%i == 0:
            print(i, end=' ')
    print(gcd)

N = int(input())
num = sorted([int(input()) for _ in range(N)])
for i in range(1, N):
    num[i] = num[i]-num[0]
check(num)