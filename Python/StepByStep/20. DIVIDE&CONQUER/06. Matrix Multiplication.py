import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
M, K = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(M)]
AxB = [[0 for cols in range(K)] for rows in range(N)]
for i in range(N):
    for j in range(K):
        for x in range(M):
            AxB[i][j] += A[i][x]*B[x][j]
for i in AxB:
    for j in i:
        print(j, end=' ')
    print()