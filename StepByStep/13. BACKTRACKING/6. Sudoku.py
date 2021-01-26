import sys

def check(y,x,v):
    nx,ny = x//3*3,y//3*3
    if(v in sudoku[x]):
        return False
    for i in range(9):
        if(v == sudoku[i][y]):
            return False
    for i in range(3):
        for j in range(3):
            if(v == sudoku[nx + i][ny + j]):
                return False
    return True

def dfs(idx):
    if(idx == len(zeros)):
        for row in sudoku:
            for n in row:
                print(n, end=" ")
            print()
        return

    for i in range(1, 10):
        nx,ny = zeros[idx][0],zeros[idx][1]
        if(check(ny,nx,i)):
            sudoku[nx][ny] = i
            dfs(idx + 1)
            sudoku[nx][ny] = 0 #sudoku[nx][ny] = i 한 뒤, 다음 레벨로 갔을때 답이 안나오면 빠져나와서 해당 인덱스 원상복구하고 다음 i로 넘어감

sudoku = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]
print(zeros)
dfs(0)