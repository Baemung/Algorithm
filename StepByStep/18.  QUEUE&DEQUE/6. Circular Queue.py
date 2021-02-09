import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
idx = list(map(int, input().split()))
deq = deque(i for i in range(1,n+1))
cnt = 0
for i in idx:
    if(deq.index(i) > len(deq)//2):
        for _ in range(len(deq) - deq.index(i)):
            deq.appendleft(deq.pop())
            cnt+=1
    else:
        for _ in range(deq.index(i)):
            deq.append(deq.popleft())
            cnt+=1
    deq.popleft()
print(cnt)