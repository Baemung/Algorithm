import sys
input = sys.stdin.readline

n, v = map(int, input().split())
u = [int(input()) for _ in range(n)]
cnt = 0
for i in range(n-1,-1,-1):
    if(v // u[i] > 0):
        cnt += v // u[i]
        v = v % u[i]
print(cnt)