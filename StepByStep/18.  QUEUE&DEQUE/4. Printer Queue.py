import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    n, m = map(int, input().split())
    score = deque(map(int, input().split()))
    idx = deque(i for i in range(n))
    cnt = 0
    while(1):
        if(score[0] >= max(score)):
            score.popleft()
            target = idx.popleft()
            cnt += 1
            if(target == m): break
        else:
            score.append(score.popleft())
            idx.append(idx.popleft())
    print(cnt)