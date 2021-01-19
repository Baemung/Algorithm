a,b = map(int, input().split())

p = set(range(2, b+1))
for i in range(2, int(b**0.5)+1):
    if(i in p):
        p -= set(range(2*i, b+1, i))
p -= set(range(a))
p = sorted(list(p))

for j in p:
    print(j)