import sys
input = sys.stdin.readline

cnt = int(input())
num = sorted(list(map(int, input().split())))
print(num[0]*num[-1])