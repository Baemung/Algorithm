a = int(input())
b = int(input())

p = set(range(2, b + 1))
for i in range(2, b + 1):
    if i in p:
        p -= set(range(2 * i, b + 1, i))
p -= set(range(a))

try:
    print("%d\n%d"%(sum(p),min(p)))
except:
    print(-1)