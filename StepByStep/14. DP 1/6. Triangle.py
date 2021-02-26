import sys
input = sys.stdin.readline

n = int(input())
triangle = [list(map(int,input().split())) for _ in range(n)]
path = triangle.copy()
for i in range(1, n):
    for j in range(len(triangle[i])):
        if j == 0:
            path[i][j] = triangle[i][j] + path[i-1][j]
        elif j == len(triangle[i])-1:
            path[i][j] = triangle[i][j] + path[i-1][j-1]
        else:
            path[i][j] = triangle[i][j] + max(path[i-1][j-1], path[i-1][j])
print(max(path[-1]))