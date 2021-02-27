import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
idx = list(map(int, input().split()))
deq = deque(range(1, N+1))
cnt = 0
for i in idx:
    if deq.index(i) > len(deq)//2: #오른쪽 이동
        for _ in range(len(deq)-deq.index(i)):
            deq.appendleft(deq.pop())
            cnt += 1
    else: #왼쪽 이동
        for _ in range(deq.index(i)):
            deq.append(deq.popleft())
            cnt += 1
    deq.popleft()
print(cnt)