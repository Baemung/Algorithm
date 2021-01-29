import sys
input = sys.stdin.readline

n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]
total = [[0 for _ in range(3)] for _ in range(n)]

for i in range(n):
    for j in range(3):
        if(i==0):
            total[i][j] = cost[i][j]
        else:
            total[i][j] = min(total[i-1][(j+1)%3], total[i-1][(j+2)%3]) + cost[i][j]

print(min(total[-1]))