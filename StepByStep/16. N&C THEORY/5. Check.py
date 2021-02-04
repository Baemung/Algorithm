import sys
input = sys.stdin.readline

def gcd_(a, b):
    while(b): a,b = b,a%b
    return a

def gcd_N(li):
    gcd = li[0]
    for num in li: gcd = gcd_(gcd,num)
    for i in range(2, gcd//2+1):
        if(gcd%i == 0): print(i, end=' ')
    print(gcd)

n = int(input())
num = sorted([int(input()) for _ in range(n)])
for i in range(1,n): num[i] = num[i]-num[0]
num = num[1:]
gcd_N(num)