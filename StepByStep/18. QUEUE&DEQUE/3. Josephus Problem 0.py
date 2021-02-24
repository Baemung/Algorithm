import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
deq = deque()
for i in range(1,n+1): deq.append(i)
idx = 0

print('<', end='')
while(1):
    idx = ((idx + k)-1)%len(deq)
    if(len(deq)==1):
        print(deq[idx], end='>')
        break
    print(deq[idx], end=', ')
    deq.remove(deq[idx])