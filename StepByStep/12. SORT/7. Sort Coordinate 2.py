import sys
input = sys.stdin.readline

li = sorted([list(map(int, input().split())) for _ in range(int(input()))], key=lambda x:(x[1], x[0]))
for i in range(len(li)):
    print(li[i][0],li[i][1])