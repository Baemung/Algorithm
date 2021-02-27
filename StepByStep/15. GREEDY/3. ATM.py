import sys
input = sys.stdin.readline

N = int(input())
P = sorted(list(map(int, input().split())))
wait, time = 0,0
for t in P:
    wait += t
    time += wait
print(time)