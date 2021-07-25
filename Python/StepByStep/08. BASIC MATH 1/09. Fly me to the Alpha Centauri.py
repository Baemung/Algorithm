def count():
    cnt, total, add = 0, 0, 1
    a, b = map(int, input().split())
    while True:
        for _ in range(2): #양 옆으로 1++씩 카운트해서 중간으로 수렴
            cnt += 1
            total += add
            if total >= (b-a):
                return cnt
        add += 1
for i in range(int(input())):
    print(count())