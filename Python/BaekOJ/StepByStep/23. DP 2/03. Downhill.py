import sys
input = sys.stdin.readline

M, N = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(M)]
dp = [[0]*N for _ in range(M)]
check = [[0]*N for _ in range(M)]

