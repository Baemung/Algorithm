import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))
max_ = li[0]
temp = 0

for i in range(n):
    temp += li[i]
    max_ = max(max_, temp)
    if(temp < 0): temp = 0

print(max_)