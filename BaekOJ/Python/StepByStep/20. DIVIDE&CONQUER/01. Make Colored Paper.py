import sys
input = sys.stdin.readline

def cut(left, right, up, down):
    global w, b
    tempW, tempB = 0, 0
    li = [rows[left:right] for rows in paper[up:down]]
    for i in li:
        for j in i:
            if j == 0:
                tempW += 1
            else:
                tempB += 1
    if tempB == len(li)**2:
        b += 1
        return
    elif tempW == len(li)**2:
        w += 1
        return
    size = len(li)
    for i in range(2):
        for j in range(2):
            cut(left+i*(size//2), left+(i+1)*(size//2), up+j*(size//2), up+(j+1)*(size//2))

w, b = 0, 0
n = int(input())
paper = [[int(i) for i in input().split()] for _ in range(n)]
cut(0, n, 0, n)
print(w, b, sep='\n')