import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

def dfs(start, tree, parents):
    for i in tree[start]: #연결된 노드 모두 탐색
        if parents[i] == 0: #한번도 방문한 적이 없다면
            parents[i] = start #부모노드 저장
            dfs(i, tree, parents) #해당 노드의 자식노드 탐색

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

#부모 저장 리스트
parents = [0 for _ in range(n+1)]

dfs(1, tree, parents)

for i in range(2, n+1):
    print(parents[i])