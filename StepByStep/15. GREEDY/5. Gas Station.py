import sys
input = sys.stdin.readline

n = int(input())
distance = list(map(int, input().split()))
cost = list(map(int, input().split()))
min_ = cost[0]
minCost = [cost[0]*distance[0]]
for i in range(1, n-1):
    min_= min(cost[i], cost[i-1], min_)
    minCost.append(distance[i]*min_)
print(sum(minCost))