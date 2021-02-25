def backtracking(idx, n, m):
    if idx == m:
        for i in range(m):
            print(result[i], end=' ')
        print()
        return
    for i in range(1, n+1):
        if check[i] == 1 or (idx > 0 and result[idx-1] > i):
            continue
        result[idx] = i
        check[i] = 1
        backtracking(idx+1, n, m)
        check[i] = 0

n,m = map(int, input().split())
check = [0]*(n+1)
result = [0]*m
backtracking(0, n, m)