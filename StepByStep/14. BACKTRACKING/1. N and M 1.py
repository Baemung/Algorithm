def backtracking(idx, n, m):
    if idx == m:
        for i in range(m):
            print(result[i], end=' ')
        print()
        return
    for i in range(1, n+1): #1부터 n까지
        if check[i] == 1: #들렀으면 패스
            continue
        result[idx] = i #값 대입
        check[i] = 1 #들렀다고 표시
        backtracking(idx+1, n, m) #다음 단계로 넘어감
        check[i] = 0 #완성이 안되면 원상복구

n, m = map(int, input().split())
check = [0]*(n+1)
result = [0]*m
backtracking(0, n, m)