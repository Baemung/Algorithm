import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data):
        self.data = data;
        self.left = None;
        self.right = None;

def preorder(node):
    print(node.data, end='')
    if node.left != '': preorder(node.left)
    if node.right != '': preorder(node.right)

def inorder(node):
    if node.left != '': inorder(node.left)
    print(node.data, end='')
    if node.right != '': inorder(node.right)

def postorder(node):
    if node.left != '': postorder(node.left)
    if node.right != '': postorder(node.right)
    print(node.data, end='')

n = int(input())
tree_li = []
for i in range(n):
    data = input().split()
    node = Node(data[0])
    if data[1] == '.': data[1] = ''
    if data[2] == '.': data[2] = ''
    node.left = data[1]
    node.right = data[2]
    tree_li.append(node)

for i in range(n):
    for j in range(n):
        if tree_li[i].data == tree_li[j].left: tree_li[j].left = tree_li[i]
        elif tree_li[i].data == tree_li[j].right: tree_li[j].right = tree_li[i]

preorder(tree_li[0])
print()
inorder(tree_li[0])
print()
postorder(tree_li[0])