def count():
    cnt = 0
    total = 0
    add = 1
    a, b = map(int, input().split())
    while(1):
        for i in range(2):
            cnt += 1
            total += add
            if(total >= (b-a)):
                return cnt
        add += 1

for i in range(int(input())):
    print(count())