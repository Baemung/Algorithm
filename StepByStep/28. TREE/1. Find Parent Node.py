import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data, parent):
        self.data = data
        self.parent = parent

n = int(input())
tree = [list(map(int, input().split())) for _ in range(n-1)]

root = Node(1, None)
for i in tree:
    for j in range(n):
        if j in i:
            if i.index(j) == 0:
                child1 = Node(i[0], root)
            else:
                child1 = Node(i[1], root)


print(n, tree)