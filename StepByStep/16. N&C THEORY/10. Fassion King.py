import sys
input = sys.stdin.readline

for i in range(int(input())):
    item = [input().split()[1] for _ in range(int(input()))]
    sum_ = 1
    for a in set(item):
        cnt = 0
        for b in item:
            if(a == b): cnt+=1
        sum_ *= (cnt+1)
    print(sum_-1)