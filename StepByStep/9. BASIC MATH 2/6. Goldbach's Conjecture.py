num = int(input())

for i in range(num):
    n = int(input())
    p = set(range(2, n+1))
    for j in range(2, int(n**0.5)+1):
        if(j in p):
            p -= set(range(2*j, n+1, j))

    x,gap = 0,n/2
    for a in p:
        b = abs(n-a)
        if(b in p and abs(a-b)<gap):
            gap = abs(a-b)
            x = a

    print(x, n-x)