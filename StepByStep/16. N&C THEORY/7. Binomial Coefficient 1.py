import sys
input = sys.stdin.readline

a, b = map(int, input().split())
c, b = a, max(a-b, b)
for i in range(b-1, 0, -1):
    c, b = c*(a-i), b*i
print(c//b)