import sys
input = sys.stdin.readline

def STACK(str):
    stack_ = []
    for i in str:
        if (i == '('): stack_.append('(')
        if (i == ')'):
            try:pop = stack_.pop()
            except:return print("NO")
            if(pop != '('): return print("NO")
    if(len(stack_)): return print("NO")
    else: print("YES")

for i in range(int(input())):STACK(input())