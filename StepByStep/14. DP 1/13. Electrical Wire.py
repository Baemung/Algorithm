import sys
input = sys.stdin.readline

n = int(input())
wire = sorted([list(map(int,input().split())) for _ in range(n)],key=lambda x:x[0])

dp = [1]*n
for i in range(1,n):
    max_ = 1
    for j in range(i-1,-1,-1):
        if(wire[i][1] > wire[j][1] and max_ < dp[j]+1):
            max_ = dp[j]+1
    dp[i] = max_

print(n-max(dp))