num = int(input())
for i in range(num):
    n, *case = list(map(int, input().split()))
    total, cnt = 0, 0
    for j in range(n):
        total += case[j]
    mean = total/n
    for j in range(n):
        if case[j] > mean:
            cnt += 1
    pct = round((cnt/n)*100, 3)
    print("%0.3f"%pct+"%")