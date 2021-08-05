import sys
input = sys.stdin.readline

N = int(input())
tower = list(map(int, input().split()))
result = [0]*N
stack = []

for i in range(N-1, -1, -1):
    while(len(stack) != 0 and tower[stack[-1]] < tower[i]):
        result[stack.pop()] = i+1
    stack.append(i)

for i in result:
    print(i, end=' ')