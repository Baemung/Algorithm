import sys
input = sys.stdin.readline

n = int(input())
seq = list(map(int, input().split()))
dp = [1]*n
for i in range(1, n):
    max_ = 1
    for j in range(i-1, -1, -1):
        if(seq[i] > seq[j] and max_ < dp[j]+1):
            max_ = dp[j]+1
    dp[i] = max_

print(max(dp))