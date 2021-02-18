import sys
input = sys.stdin.readline
'''
def dq(start, end):
    global res
    if end-start < 1:
        return

    height = min(case[start:end+1])
    for i in range(start,end+1):
        if case[i] == height:
            low = i
            break
        elif case[end-i] == height:
            low = end-i
            break
    res = max(res, height*(end-start+1))
    dq(start, low-1)
    dq(low+1, end)
    return

while True:
    n, *case = list(map(int, input().split()))
    if n == 0:
        break
    if len(set(case)) == 1:
        print(n * case[0])
        continue
    res = max(case)
    dq(0, n-1)
    print(res)
'''

while True:
    n, *h = list(map(int, input().split()))
    h.insert(0, 0)
    h.append(0)
    if n == 0:
        break
    c = [0]
    a = 0
    for i in range(1, n + 2):
        while c and (h[c[-1]] > h[i]):
            cur_h = c.pop()
            a = max(a, (i - 1 - c[-1]) * h[cur_h])
        c.append(i)
    print(a)