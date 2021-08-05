import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

preorder = []
while True:
    try: node = int(input())
    except: break
    preorder.append(node)

def postorder(start, end):
    if start >= end:
        return

    div = end
    for i in range(start+1, end):
        if preorder[start] < preorder[i]:
            div = i
            break

    postorder(start+1, div)
    postorder(div, end)
    print(preorder[start])

postorder(0, len(preorder))