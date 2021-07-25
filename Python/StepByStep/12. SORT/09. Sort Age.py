import sys
input = sys.stdin.readline

p = sorted(list(input().split() for _ in range(int(input()))), key=lambda x:int(x[0]))
for i in range(len(p)):
    print(int(p[i][0]), p[i][1])