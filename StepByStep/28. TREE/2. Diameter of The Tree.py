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
for i in range(n):
    node = list(map(int, input().split()))
    for j in range(1, len(node)-1, 2):
        tree[node[0]].append(node[j:j+2])
        # 처음에는 tree[i]로 해주었더니 틀렸습니다가 나와서 찾아보니
        # 테스트케이스 입력이 1,2,3,4,,, 처럼 순차적으로 주어진다는 명시가 없었다.
        # tree[node[0]] 로 수정해주니 간단하게 해결되었다.

dist, node = bfs(1)
dist, node = bfs(node)
print(dist)