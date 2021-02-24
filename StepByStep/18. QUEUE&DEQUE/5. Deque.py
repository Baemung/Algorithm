import sys
from collections import deque
input = sys.stdin.readline

def CMD(li):
    if(li[0] == "size"): print(len(deq))
    elif(li[0] == "push_back"): deq.append(li[1])
    elif(li[0] == "push_front"): deq.appendleft(li[1])
    elif (li[0] == "pop_back"):
        try: p = deq.pop()
        except: p = -1
        print(p)
    elif (li[0] == "pop_front"):
        try: p = deq.popleft()
        except: p = -1
        print(p)
    elif(li[0] == "back"):
        if(len(deq)): print(deq[-1])
        else: print(-1)
    elif(li[0] == "front"):
        if(len(deq)): print(deq[0])
        else:print(-1)
    elif(li[0] == "empty"):
        if(len(deq)):print(0)
        else: print(1)

deq = deque()
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)