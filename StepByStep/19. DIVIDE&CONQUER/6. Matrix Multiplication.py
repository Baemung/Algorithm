import sys
input = sys.stdin.readline

n,m = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
m,k = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(m)]

AxB = [[0 for cols in range(k)] for rows in range(n)]

for i in range(n):
    for j in range(k):
        for x in range(m):
            AxB[i][j] += A[i][x] * B[x][j]

for i in AxB:
    for j in i:
        print(j, end=' ')
    print()