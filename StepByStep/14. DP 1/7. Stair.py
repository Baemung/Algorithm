import sys
input = sys.stdin.readline

n = int(input())
stair = [int(input()) for _ in range(n)]
score = [0]*n

score[0] = stair[0]
if(n>1): score[1] = stair[0] + stair[1]
if(n>2):
    score[2] = max(score[0], stair[1]) + stair[2]
    for i in range(3,n):
        score[i] = max(score[i-2], score[i-3]+stair[i-1]) + stair[i]

print(score[n-1])