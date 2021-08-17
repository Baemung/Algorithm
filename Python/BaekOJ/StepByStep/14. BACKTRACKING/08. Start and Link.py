import sys
input = sys.stdin.readline
min_ = sys.maxsize

def make_Team(idx, n, m):
    if idx == m:
        result.append(calculate(check))
    else:
        for i in range(n):
            if i in check or (idx > 0 and check[idx-1] > i):
                continue
            check[idx] = i
            make_Team(idx+1, n, m)
            check[idx] = -1

def calculate(li):
    num = 0
    for i in li:
        for j in li:
            if i == j:
                continue
            num += S[i][j]
    return num

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]
check = [-1]*(N//2) #조합을 만드는 리스트
result = [] #모든 능력치의 합을 담을 리스트
make_Team(0, N, N//2)
for i in range(len(result)//2):
    if abs(result[i] - result[len(result)-i-1]) < min_: #result[i]가 팀을 이루면 나머지팀은 result[len(result)-i-1]가 됨
        min_ = abs(result[i] - result[len(result)-i-1])
print(min_)