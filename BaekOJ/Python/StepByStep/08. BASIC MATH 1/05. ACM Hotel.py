num = int(input())
for i in range(num):
    H, W, N = map(int, input().split())
    if N%H == 0: #0층이 없으니, 꼭대기 층
        a = H
        b = N//H
    else: #나머지 층
        a = N%H
        b = (N//H)+1
    print("%d%02d"%(a, b))