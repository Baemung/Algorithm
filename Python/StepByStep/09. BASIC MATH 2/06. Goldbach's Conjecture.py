import sys
input = sys.stdin.readline

n = int(input())
p_list = [int(input()) for _ in range(n)]
p = set(range(2, max(p_list)+1))
for i in range(2, int(max(p_list)**0.5)+1):
    if i in p:
        p -= set(range(2*i, max(p_list)+1, i))
for a in p_list:
    k = 0
    for x in sorted(list(p)):
        y = a-xx
        if y-x < 0:
            break
        elif y in p:
            k = y
    print(a-k, k)