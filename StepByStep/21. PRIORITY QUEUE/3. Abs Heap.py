import sys, heapq
input = sys.stdin.readline

def heapcmd(num):
    if num == 0:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)
    else:
        heapq.heappush(heap, (abs(num), num)) #num의 절대값을 기준으로 Min heap 형성

heap = []
for _ in range(int(input())):
    heapcmd(int(input()))