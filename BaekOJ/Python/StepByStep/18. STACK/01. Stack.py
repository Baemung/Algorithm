import sys
input = sys.stdin.readline

def CMD(li):
    cmd, *n = li
    if cmd == "push":
        stack.append(n[0])
    elif cmd == "size":
        print(len(stack))
    elif cmd == "top":
        if len(stack):
            print(stack[-1])
        else:
            print(-1)
    elif cmd == "empty":
        if len(stack):
            print(0)
        else:
            print(1)
    elif cmd == "pop":
        try:
            p = stack.pop()
        except:
            p = -1
        print(p)
    return

stack = []
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)