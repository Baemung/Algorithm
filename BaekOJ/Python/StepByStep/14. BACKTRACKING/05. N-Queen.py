def n_Queen(idx, n):
    global cnt
    if idx == n:
        cnt += 1
        return
    for i in range(n):
        if board[idx][i] != 0:
            continue
        mark(n, idx, i)
        n_Queen(idx+1, n)
        back(n, idx)

def mark(n, idx, i):
    for a in range(idx+1,n):
        for b in range(n):
            if board[a][b] != 0:
                continue
            if a == idx:
                board[a][b] = idx + 1
            elif b == i:
                board[a][b] = idx + 1
            elif abs(a - idx) == abs((b - i)):
                board[a][b] = idx + 1

def back(n, idx):
    for a in range(idx+1,n):
        for b in range(n):
            if board[a][b] == idx+1:
                board[a][b] = 0

n = int(input())
board = [[0]*n for i in range(n)]
cnt = 0
n_Queen(0,n)
print(cnt)