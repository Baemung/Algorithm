import sys
input = sys.stdin.readline

def fac(n):
    for i in range(n-1, 1, -1):
        n = (n*i)%mod
    return n

def power(x, y):
    if y == 0:
        return 1
    elif y%2 == 1:
        return (power(x, y//2)**2*x)%mod
    else:
        return (power(x, y//2)**2)%mod

N, K = map(int, input().split())
mod = 1_000_000_007
if N == K or K == 0:
    print(1)
else:
    a, b, c = fac(N), fac(K), fac(N-K)
    print((a*power(b*c, mod-2)) % mod)