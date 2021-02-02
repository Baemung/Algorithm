import sys
input = sys.stdin.readline

n = int(input())
t = sorted(list(map(int, input().split())))
w, s = 0,0
for i in t:
    w += i
    s += w
print(s)