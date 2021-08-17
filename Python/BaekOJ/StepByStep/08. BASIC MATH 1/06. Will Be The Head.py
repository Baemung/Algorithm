num = int(input())
for i in range(num):
    k, n = int(input()), int(input())
    h = [[0] * n for i in range(k+1)]
    for j in range(1, n+1):
        h[0][j-1] = j
    for a in range(1, k+1):
        for b in range(1, n+1):
            h[a][b-1] = h[a-1][b-1]+h[a][b-2]
    print(h[k][n-1])