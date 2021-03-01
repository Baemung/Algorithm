import sys, heapq
input = sys.stdin.readline

def heapcmd(num):
    if num == 0:
        try:
            print(heapq.heappop(heap))
        except:
            print(0)
    else:
        heapq.heappush(heap, num)

heap = []
for _ in range(int(input())):
    heapcmd(int(input()))