import sys
input = sys.stdin.readline

def CMD(li):
    if(len(li) == 2):
        stack.append(li[1])
    elif(li[0] == "top"):
        if(len(stack)): print(stack[-1])
        else:print(-1)
    elif(li[0] == "size"):
        print(len(stack))
    elif (li[0] == "pop"):
        try: p = stack.pop()
        except: p = -1
        print(p)
    else:
        if(len(stack)):print(0)
        else: print(1)
    return

stack = []
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)