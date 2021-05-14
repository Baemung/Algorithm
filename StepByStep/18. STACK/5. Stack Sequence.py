import sys
input = sys.stdin.readline

def symbol(n):
    global top
    for i in range(top+1, n+1): #저장된 높이를 이용하여 스택에 수를 추가
        stack.append(i)
        sym.append('+')
    if stack.pop() != n:
        return 1
    sym.append('-')
    top = max(top, n) #높이 저장
    return 0

stack, sym, top = [], [], 0
for i in range(int(input())):
    if symbol(int(input())):
        print('NO')
        exit(0)
for i in sym:
    print(i)