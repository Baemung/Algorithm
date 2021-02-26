import sys
input = sys.stdin.readline

n, w = map(int, input().split())
obj = sorted([list(map(int, input().split())) for _ in range(n)],key=lambda x:x[0])
dp = [[0]*(w+1) for _ in range(2)]
for i in range(n):
    for j in range(1, w+1):
        if obj[i][0] > j:
            dp[i%2][j] = dp[(i-1)%2][j]
        else:
            dp[i%2][j] = max(dp[(i-1)%2][j], dp[(i-1)%2][j-obj[i][0]]+obj[i][1])
print(dp[(n-1)%2][w])