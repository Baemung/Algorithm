import sys
input = sys.stdin.readline

def cut(left, right, up, down):
    global mo, z, o
    tempMO, tempZ, tempO = 0, 0, 0

    li = [rows[left:right] for rows in paper[up:down]]
    for i in li:
        for j in i:
            if j == -1: tempMO += 1
            elif j == 0: tempZ += 1
            else: tempO += 1

    if tempMO == len(li)**2:
        mo += 1
        return
    if tempZ == len(li)**2:
        z += 1
        return
    if tempO == len(li)**2:
        o += 1
        return

    size = len(li)
    for i in range(3):
        for j in range(3):
            cut(left+i*(size//3), left+(i+1)*(size//3), up+j*(size//3), up+(j+1)*(size//3))

mo, z, o = 0, 0, 0
n = int(input())
paper = [[int(i) for i in input().split()] for _ in range(n)]
cut(0, n, 0, n)
print(mo, z, o, sep='\n')