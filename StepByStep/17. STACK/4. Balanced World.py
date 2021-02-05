import sys
input = sys.stdin.readline

def search_B(str):
    stack_=[]
    for i in str:
        if(i == '('): stack_.append('(')
        if(i == '['): stack_.append('[')
        if(i == ')'):
            try: pop = stack_.pop()
            except: return print("no")
            if(pop != '('): return print("no")
        if(i == ']'):
            try: pop = stack_.pop()
            except: return print("no")
            if(pop != '['): return print("no")

    if(len(stack_)): return print("no")
    else: return print("yes")

while(1):
    str_ = input()
    if(str_[0] == '.'): break
    search_B(str_)