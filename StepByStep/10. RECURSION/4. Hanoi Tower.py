def hanoi(n, a, b, c):
    if(n == 0):
        return
    hanoi(n-1,a,c,b)
    print(a,c)
    hanoi(n-1,b,a,c)

n, cnt, mv = int(input()), 0, 0
while(cnt != n):
    mv = 2*mv + 1
    cnt += 1

print(mv)
hanoi(n, 1, 2, 3)