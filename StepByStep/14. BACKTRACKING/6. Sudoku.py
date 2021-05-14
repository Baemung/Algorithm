import sys
input = sys.stdin.readline

def check(nx,ny,v):
    if v in sudoku[ny]: #가로
        return False
    for i in range(9): #세로
        if v == sudoku[i][nx]:
            return False
    x = (nx//3)*3
    y = (ny//3)*3
    for a in range(3): #3*3박스 좌측상단부터 체크
        for b in range(3):
            if v == sudoku[y+a][x+b]:
                return False
    return True

def backtracking(idx):
    if idx == len(zeros):
        for rows in sudoku:
            for n in rows:
                print(n, end=' ')
            print()
        sys.exit(0)
    for i in range(1, 10):
        nx = zeros[idx][1]
        ny = zeros[idx][0]
        if check(nx, ny, i):
            sudoku[ny][nx] = i
            backtracking(idx+1)
            sudoku[ny][nx] = 0

sudoku = [list(map(int, input().split())) for _ in range(9)]
zeros = [[i,j] for i in range(9) for j in range(9) if(sudoku[i][j] == 0)]
backtracking(0)