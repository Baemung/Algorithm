import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    check = [-1] * (n + 1) # 방문 체크
    que = deque([start])
    check[start] = 0
    _max = [0, 0] # maxlen[0]은 해당 노드까지의 최대 거리, maxlen[1]은 해당 노드
    while que:
        t = que.popleft()
        for e, w in tree[t]: # e:노드, w:거리
            if check[e] == -1: # 해당 노드에 방문하지 않았다면
                que.append(e) #큐에 노드 추가
                check[e] = check[t] + w # 체크한 곳에 해당 거리 업데이트
                if _max[0] < check[e]: # 최대 거리 노드 갱신
                    _max = check[e], e
    return _max

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    node = list(map(int, input().split())) # 부모노드, 자식노드, 웨이트가 입력됨
    tree[node[0]].append([node[1],node[2]]) #부모노드에 자식노드 데이터 추가
    tree[node[1]].append([node[0],node[2]]) #자식노드에 부모노드 데이터 추가

dist, node = bfs(1) #루트에서 가장 먼 노드 bfs탐색
dist, node = bfs(node) #루트에서 가장 먼 노드에서 가장 먼 노드 bfs탐색 -> 트리의 지름
print(dist)