import sys
input = sys.stdin.readline
min_ = sys.maxsize

def makeTeam(idx, n, m):
    if(idx == m):
        v.append(calc(b))
    else:
        for i in range(n):
            if(i in b):
                continue
            if(idx>0 and b[idx-1]>i):
                continue
            b[idx] = i
            makeTeam(idx+1, n, m)
            b[idx] = -1

def calc(li):
    num = 0
    for i in li:
        for j in li:
            if(i == j):
                continue
            num += a[i][j]
    return num

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
b = [-1]*(n//2)
v = []

makeTeam(0,n,n//2)
for i in range(len(v)//2):
    if(abs(v[i] - v[len(v)-i-1]) < min_):
        min_ = abs(v[i] - v[len(v)-i-1])

print(min_)