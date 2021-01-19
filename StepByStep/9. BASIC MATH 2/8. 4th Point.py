a = []
b = []
for i in range(3):
    x, y = map(int, input().split())
    a.append(x)
    b.append(y)

a = sorted(a, key=a.count)
b = sorted(b, key=b.count)
print(a[0], b[0])