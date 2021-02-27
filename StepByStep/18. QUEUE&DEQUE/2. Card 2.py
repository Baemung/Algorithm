import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
deq_ = deque(i for i in range(1, N+1))
while len(deq_) > 1:
    deq_.popleft()
    deq_.append(deq_.popleft())
print(deq_[0])