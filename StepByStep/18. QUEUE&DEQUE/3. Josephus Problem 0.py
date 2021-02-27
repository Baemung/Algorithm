import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
deq_ = deque(i for i in range(1, N+1))
idx = 0
print('<', end='')
while True:
    idx = ((idx+K)-1)%len(deq_)
    if len(deq_) == 1:
        print(deq_[idx], end='>')
        break
    print(deq_[idx], end=', ')
    deq_.remove(deq_[idx])