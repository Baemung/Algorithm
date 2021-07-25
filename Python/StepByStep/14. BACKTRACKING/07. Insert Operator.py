import sys
input = sys.stdin.readline
max_ = -sys.maxsize
min_ = sys.maxsize

def calculate(i, res, add, sub, mul, div):
    global max_, min_
    if i == n:
        max_, min_ = max(max_, res), min(min_, res)
    if add:
        calculate(i+1, res+li[i], add-1, sub, mul, div)
    if sub:
        calculate(i+1, res-li[i], add, sub-1, mul, div)
    if mul:
        calculate(i+1, res*li[i], add, sub, mul-1, div)
    if div:
        calculate(i+1, int(res/li[i]), add, sub, mul, div-1)

n = int(input())
li = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
calculate(1, li[0], add, sub, mul, div)
print(max_, min_, sep='\n')