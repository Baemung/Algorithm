import sys
input = sys.stdin.readline

num = int(input())
factor = sorted(list(map(int, input().split())))
print(factor[0]*factor[-1])