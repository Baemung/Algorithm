import sys
input = sys.stdin.readline

def matMul(mat1, mat2):
    resMat = [[0 for _ in range(2)] for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for x in range(2):
                resMat[i][j] += (mat1[i][x] * mat2[x][j])
            resMat[i][j] %= mod
    return resMat

def divConq(a, n):
    if n == 1:
        return a
    tmp = divConq(a, n//2)
    if n%2 == 0:
        return matMul(tmp, tmp)
    else:
        return matMul(matMul(tmp, tmp), a)

N = int(input())
A = [[1,1],[1,0]]
mod = 1_000_000_007
print(divConq(A,N)[0][1])