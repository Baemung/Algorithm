import sys
input = sys.stdin.readline

li = sorted(list(int(input()) for _ in range(int(input()))))
for i in li:
    print(i)