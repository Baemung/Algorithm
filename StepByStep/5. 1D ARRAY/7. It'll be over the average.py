num = int(input())

for i in range(num):
    case = [int(score) for score in input().split()]
    total = 0
    cnt = 0
    for j in range(case[0]):
        total += case[j+1]

    mean = total/case[0]
    for j in range(case[0]):
        if(case[j+1] > mean):
            cnt += 1
    pct = round((cnt/case[0])*100,3)

    print("%0.3f"%pct+"%")