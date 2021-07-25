import sys
input = sys.stdin.readline

def cnt(num, div):
    ans = 0
    while num:
        num //= div
        ans += num
    return ans

n, m = map(int, input().split())
if m == 0:
    print(0)
else:
    print(min(cnt(n, 2)-cnt(m, 2)-cnt(n-m, 2), cnt(n, 5)-cnt(m, 5)-cnt(n-m, 5)))