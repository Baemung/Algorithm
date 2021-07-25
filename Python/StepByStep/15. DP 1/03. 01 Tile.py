import sys
input = sys.stdin.readline

n = int(input())
f = [1,1,2]+[0]*(n-2)
for i in range(3, n+1):
    f[i] = (f[i-1]+f[i-2])%15746
print(f[n])