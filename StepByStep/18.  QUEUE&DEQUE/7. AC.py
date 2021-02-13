import sys
from collections import deque
input = sys.stdin.readline

def AC(p,dq):
    global r
    for i in p:
        if i == 'D':
            if len(dq) == 0 or dq[0] == '': return "error"
            elif r: dq.pop()
            else: dq.popleft()
        else: r = (r+1)%2

    if r: dq.reverse()
    str_ = '['
    str_ += ','.join(dq)
    str_ += ']'
    return str_

for _ in range(int(input())):
    f = deque(input()[:-1])
    n = int(input())
    r = 0
    num = ""
    for i in input():
        if(i.isdigit()): num += i
        else: num += " "
    deq = deque(num.split(' ')[1:-2])
    print(AC(f,deq))