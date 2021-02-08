import sys
input = sys.stdin.readline

def symbol(n):
    global s
    for i in range(s+1,n+1):
        stack.append(i)
        sym.append('+')
    if (stack.pop() != n): return 1
    sym.append('-')
    s = max(s,n)

stack,sym,s = [],[],0
for i in range(int(input())):
    if(symbol(int(input()))):
        print('NO')
        exit(0)
for i in sym: print(i)