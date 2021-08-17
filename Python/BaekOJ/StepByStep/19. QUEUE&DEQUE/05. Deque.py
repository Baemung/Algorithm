import sys
from collections import deque
input = sys.stdin.readline

def CMD(cmd):
    cmd, *num = cmd
    if cmd == "size":
        print(len(deq_))
    elif cmd == "push_back":
        deq_.append(num[0])
    elif cmd == "push_front":
        deq_.appendleft(num[0])
    elif cmd == "pop_back":
        try:
            p = deq_.pop()
        except:
            p = -1
        print(p)
    elif cmd == "pop_front":
        try:
            p = deq_.popleft()
        except:
            p = -1
        print(p)
    elif cmd == "back":
        if len(deq_):
            print(deq_[-1])
        else:
            print(-1)
    elif cmd == "front":
        if len(deq_):
            print(deq_[0])
        else:
            print(-1)
    elif cmd == "empty":
        if len(deq_):
            print(0)
        else:
            print(1)

deq_ = deque()
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)