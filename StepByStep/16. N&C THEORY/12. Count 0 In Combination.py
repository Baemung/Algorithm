import sys
input = sys.stdin.readline

def prime(n):
    for i in range(2,n+1):
        while(n>1):
            if(n%i == 0):
                n //= i
                print(i)
            else:
                break

def fac(n):
    f,k,cnt = 1,0,0
    while(n): f,n = f*n, n-1
    return f

def com(n,m):
    c = fac(n)//(fac(n-m)*fac(m))
    return c

n,m = map(int, input().split())
print(com(n,min(m,n-m)))