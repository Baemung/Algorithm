import sys
from collections import deque
input = sys.stdin.readline

def AC(p,dq):
    global r
    for i in p:
        if i == 'D':
            if len(dq) == 0 or dq[0] == '':
                return "error"
            elif r:
                dq.pop()
            else:
                dq.popleft()
        else: #i가 D아니면 R이니까 r로 방향 컨트롤(실제로 바꾸지는 않고 데크로 좌우 전환)
            r = (r+1)%2

    if r: #최종 r값으로 한번만 바꾸던가 아예 안바꿈
        dq.reverse()
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
        if i.isdigit():
            num += i
        else:
            num += " "
    deq = deque(num.split(' ')[1:-2])
    print(AC(f,deq))