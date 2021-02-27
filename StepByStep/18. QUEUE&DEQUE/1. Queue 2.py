import sys
from collections import deque
input = sys.stdin.readline

def CMD(cmd):
    cmd, *num = cmd
    if cmd == 'push':
        deq_.appendleft(num[0])
    elif cmd == "front":
        if len(deq_):
            print(deq_[-1])
        else:
            print(-1)
    elif cmd == "back":
        if len(deq_):
            print(deq_[0])
        else:
            print(-1)
    elif cmd == "empty":
        if len(deq_):
            print(0)
        else:
            print(1)
    elif cmd == "size":
        print(len(deq_))
    elif cmd == "pop":
        try:
            p = deq_.pop()
        except:
            p = -1
        print(p)

deq_ = deque()
for i in range(int(input())):
    cmd = input().split()
    CMD(cmd)