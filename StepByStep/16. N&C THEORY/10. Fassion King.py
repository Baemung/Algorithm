import sys
input = sys.stdin.readline

for i in range(int(input())):
    item = [input().split()[1] for _ in range(int(input()))]
    sum_ = 1
    for a in set(item):
        cnt = 0
        for b in item:
            if a == b:
                cnt+=1
        sum_ *= (cnt+1) #아이템 옵션중에 안입는다를 추가하여 모두 곱해줌
    print(sum_-1) #모두 안입는 케이스 한가지를 제외