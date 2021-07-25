import sys
input = sys.stdin.readline

w = [[[0 for col in range(21)] for row in range(21)] for depth in range(21)]
for a in range(21):
    for b in range(21):
        for c in range(21):
            if a == 0 or b == 0 or c == 0:
                w[a][b][c] = 1
                continue
            if a < b and b < c:
                w[a][b][c] = w[a][b][c-1] + w[a][b-1][c-1] - w[a][b-1][c]
            else:
                w[a][b][c] = w[a-1][b][c] + w[a-1][b-1][c] + w[a-1][b][c-1] - w[a-1][b-1][c-1]
while True:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
    if a <= 0 or b <= 0 or c <= 0:
        print("w(%d, %d, %d) = %d"%(a, b, c, w[0][0][0]))
    elif a > 20 or b > 20 or c > 20:
        print("w(%d, %d, %d) = %d"%(a, b, c, w[20][20][20]))
    else:
        print("w(%d, %d, %d) = %d"%(a, b, c, w[a][b][c]))