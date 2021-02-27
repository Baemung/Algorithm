import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
stack = []
result = [-1]*N
for i in range(N):
    try:
        while A[stack[-1]] < A[i]:
            result[stack.pop()] = A[i]
    except:
        pass
    stack.append(i)
for i in result:
    print(i, end=' ')