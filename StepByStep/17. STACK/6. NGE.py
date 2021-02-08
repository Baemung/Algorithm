import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
stack,result= [],[-1]*n

for i in range(len(li)):
    try:
        while li[stack[-1]] < li[i]:
            result[stack.pop()] = li[i]
    except: pass
    stack.append(i)

for i in range(n):
    print(result[i], end=' ')