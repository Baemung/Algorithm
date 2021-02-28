import sys
input = sys.stdin.readline

def matMul(n, mat1, mat2):
    resMat = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for x in range(n):
                resMat[i][j] += (mat1[i][x]*mat2[x][j])%mod
            resMat[i][j] %= mod
    return resMat

def divConq(n, a, b):
    if b == 1:
        for i in range(n):
            for j in range(n):
                a[i][j] %= mod
        return a
    tmp = divConq(n, a, b//2)
    if b%2 == 0:
        return matMul(n, tmp, tmp)
    else:
        return matMul(n, matMul(n, tmp, tmp), a)

N, B = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
mod = 1000
for i in divConq(N, A, B):
    for j in i:
        print(j, end=' ')
    print()