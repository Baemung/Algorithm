def nQ(idx, n):
    global cnt
    if(idx == n):
        cnt += 1
        return
    for i in range(n):
        if(check[idx][i] != 0): continue
        mark(n, idx, i)
        result[idx] = i
        nQ(idx+1, n)
        back(n, idx)

def mark(n, idx, i):
    for a in range(idx+1,n):
        for b in range(n):
            if(check[a][b] != 0): continue
            if(a == idx):
                check[a][b] = idx + 1
            elif(b == i):
                check[a][b] = idx + 1
            elif(abs(a - idx) == abs((b - i))):
                check[a][b] = idx + 1

def back(n, idx):
    for a in range(idx+1,n):
        for b in range(n):
            if(check[a][b] == idx+1):
                check[a][b] = 0

n = int(input())
check = [[0]*n for i in range(n)]
result = [0]*n
cnt = 0

nQ(0,n)
print(cnt)