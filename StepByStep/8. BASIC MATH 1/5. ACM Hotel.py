num = int(input())

for i in range(num):
    w, h, n = map(int, input().split())
    if(n % w == 0):
        a = w
        b = n//w
    else:
        a = n % w
        b = (n // w) + 1

    print("%d%02d"%(a, b))