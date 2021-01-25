def seq(idx, n, m):
    if(idx == m):
        for i in range(m):
            print(result[i], end=' ')
        print()
        return

    for i in range(1, n+1):
        result[idx] = i
        if(idx > 0 and result[idx-1] > i):
            continue
        seq(idx+1, n, m)

n, m = map(int, input().split())
result = [0]*m

seq(0, n, m)