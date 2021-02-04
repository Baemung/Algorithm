import sys
input = sys.stdin.readline

num = int(input())
for i in range(num):
    n,m = map(int, input().split())
    k=m
    for j in range(n-1,0,-1):
        k,n = k*(m-j),n*j
    print(k//n)