import sys
from collections import deque
input = sys.stdin.readline

def AC(p,dq):
    for i in p:
        if i == 'D':
            if len(dq) == 0 or dq[0] == '':
                return "error"
            dq.popleft()
        else:
            dq.reverse()
    str_ = '['
    str_ += ','.join(dq)
    str_ += ']'
    return str_

for _ in range(int(input())):
    f = deque(input()[:-1])
    n = int(input())
    num = ""
    for i in input():
        if(i.isdigit()): num += i
        else: num += " "
    deq = deque(num.split(' ')[1:-2])
    print(AC(f,deq))