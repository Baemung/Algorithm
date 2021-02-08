import sys
from collections import deque
input = sys.stdin.readline

def CMD(li):
    if(len(li) == 2):
        deq_.appendleft(li[1])
    elif(li[0] == "front"):
        if(len(deq_)): print(deq_[-1])
        else:print(-1)
    elif(li[0] == "back"):
        if(len(deq_)): print(deq_[0])
        else: print(-1)
    elif(li[0] == "empty"):
        if(len(deq_)):print(0)
        else: print(1)
    elif(li[0] == "size"):
        print(len(deq_))
    elif(li[0] == "pop"):
        try: p = deq_.pop()
        except: p = -1
        print(p)
    return

deq_ = deque()
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)