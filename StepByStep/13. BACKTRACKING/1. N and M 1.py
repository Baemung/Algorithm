def sequence(idx, n, m):
    if(idx == m):
        for i in range(m):
            print(result[i], end=' ')
        print()
        return

    for i in range(1, n + 1):
        if(check[i] == 1):
            continue
        result[idx] = i
        check[i] = 1
        sequence(idx + 1, n, m)
        check[i] = 0

n,m = map(int, input().split())
check=[0]*(n+1)
result=[0]*m

sequence(0, n, m)