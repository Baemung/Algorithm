num = int(input())
for i in range(num):
    pt, total = 0, 0
    q = input()
    for j in q:
        if j == 'O':
            pt += 1
        else:
            pt = 0
        total += pt
    print(total)