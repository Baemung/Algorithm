import sys
from collections import deque
input = sys.stdin.readline

for _ in range(int(input())):
    N, M = map(int, input().split())
    score = deque(map(int, input().split()))
    idx = deque(range(N))
    cnt = 0
    while True:
        if score[0] >= max(score): #최우선 순위면
            score.popleft()
            target = idx.popleft()
            cnt += 1
            if target == M: #목표를 찾으면 끝
                break
        else:
            score.append(score.popleft()) #뒤로 미루기
            idx.append(idx.popleft()) #뒤로 미루기
    print(cnt)