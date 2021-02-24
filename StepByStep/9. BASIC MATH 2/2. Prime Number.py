M, N = int(input()), int(input())
P = set(range(2, N+1))
for i in range(2, N+1):
    if i in P:
        P -= set(range(2*i, N+1, i))
P -= set(range(M))
try:
    print("%d\n%d"%(sum(P), min(P)))
except:
    print(-1)