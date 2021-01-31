import sys
input = sys.stdin.readline

n = int(input())
seq = list(map(int, input().split()))
dpB=[1]*n
dpF=[1]*n
dp=[0]*n

for i in range(n):
    max_B = 0
    for j in range(i-1,-1,-1):
        if ((seq[i] > seq[j] and max_B < dpB[j])):
            max_B = dpB[j]
            dpB[i] =max_B+1
for i in range(n-1,-1,-1):
    max_F = 0
    for j in range(i,n):
        if ((seq[i] > seq[j] and max_F < dpF[j])):
            max_F = dpF[j]
            dpF[i] =max_F+1
for i in range(n):
    dp[i]=dpF[i] + dpB[i] - 1

print(max(dp))