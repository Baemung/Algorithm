import sys
input = sys.stdin.readline

def quadT(left, right, up, down):
    global ans
    li = [rows[left:right] for rows in img[up:down]]
    temp0, temp1 = 0, 0
    for i in li:
        for j in i:
            if(j == '0'): temp0 += 1
            else: temp1 += 1
    if temp1 == len(li)**2:
        ans += '1'
        return
    if temp0 == len(li)**2:
        ans += '0'
        return

    ans += '('
    quadT(left, (left + right) // 2, up, (up + down) // 2)
    quadT((left + right) // 2, right, up, (up + down) // 2)
    quadT(left, (left + right) // 2, (up + down) // 2, down)
    quadT((left + right) // 2, right, (up + down) // 2, down)
    ans += ')'

ans = ''
n = int(input())
img = [input()[:-1] for _ in range(n)]
quadT(0,n,0,n)
print(ans)