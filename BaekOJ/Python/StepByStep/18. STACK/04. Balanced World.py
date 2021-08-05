import sys
input = sys.stdin.readline

def search_B(str):
    stack_=[]
    for i in str:
        if i == '(':
            stack_.append('(')
        elif i == '[':
            stack_.append('[')
        elif i == ')':
            try:
                pop = stack_.pop()
            except:
                return print("no")
            if pop != '(':
                return print("no")
        elif i == ']':
            try:
                pop = stack_.pop()
            except:
                return print("no")
            if pop != '[':
                return print("no")
    if len(stack_):
        return print("no")
    else:
        return print("yes")

while True:
    str_ = input()
    if str_[0] == '.':
        break
    search_B(str_)