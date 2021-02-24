import sys
import statistics as s
input = sys.stdin.readline

num = sorted([int(input()) for _ in range(int(input()))])
cnt = s.multimode(num)
if len(cnt) >= 2:
    a=cnt[1]
else:
    a=cnt[0]
print(round(s.mean(num)), s.median(num), a, num[-1]-num[0], sep='\n')