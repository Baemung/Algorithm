import sys

def check(y,x,v):
    nx = (x//3)*3
    ny = (y//3)*3
    if(v in sudoku[y]):
        return False
    for i in range(9):
        if(v == sudoku[i][x]):
            return False
    for a in range(3):
        for b in range(3):
            if(v == sudoku[ny+a][nx+b]):
                return False
    return True

def dfs(idx):
    if(idx == len(zeros)):
        for rows in sudoku:
            for n in rows:
                print(n, end=' ')
            print()
        return
    for i in range(1, 10):
        nx = zeros[idx][1]
        ny = zeros[idx][0]
        if(check(ny, nx, i)):
            sudoku[ny][nx] = i
            dfs(idx+1)
            sudoku[ny][nx] = 0

sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zeros = [[i,j] for i in range(9) for j in range(9) if(sudoku[i][j] == 0)]
dfs(0)