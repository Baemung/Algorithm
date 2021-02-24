M, N = map(int, input().split())
P = set(range(2, N+1))
for i in range(2, int(N**0.5)+1):
    if i in P:
        P -= set(range(2*i, N+1, i))
P -= set(range(M))
P = sorted(list(P))
for i in P:
    print(i)