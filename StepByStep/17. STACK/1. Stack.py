import sys
input = sys.stdin.readline

def CMD(li):
    if(len(li) == 2):
        stack_.append(li[1])
    elif(li[0] == "top"):
        if(len(stack_)): print(stack_[-1])
        else:print(-1)
    elif(li[0] == "size"):
        print(len(stack_))
    elif (li[0] == "pop"):
        try: p = stack_.pop()
        except: p = -1
        print(p)
    else:
        if(len(stack_)):print(0)
        else: print(1)
    return

stack_ = []
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)