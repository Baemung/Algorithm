import sys, heapq
input = sys.stdin.readline

def get_mid(num):
    if len(heap_Max) == len(heap_Min): #짝수일 때, 작은수를 출력하기 위해 heap_Max로 push
        heapq.heappush(heap_Max, -num)
    else:
        heapq.heappush(heap_Min, num) #홀수일 때, 일단은 heap_Min으로 push
    if heap_Min and -heap_Max[0] > heap_Min[0]: #heap_Min에 엘리먼트가 있으면서, heap_Max의 최대값보다 heap_Min의 최솟값이 더 클때
        tempMin = heapq.heappop(heap_Min)
        tempMax = -heapq.heappop(heap_Max)
        heapq.heappush(heap_Min, tempMax)
        heapq.heappush(heap_Max, -tempMin) #서로 값 교환
    print(-heap_Max[0]) #중간값 출력

heap_Max, heap_Min = [], [] #heap_Max는 중간값을 기준으로 작은값들의 Max heap, heap_Min은 중간을 기준으로 큰값들의 Min heap.
for _ in range(int(input())):
    get_mid(int(input()))