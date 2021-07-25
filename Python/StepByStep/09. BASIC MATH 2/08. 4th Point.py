loc = list(zip(*[list(map(int, input().split())) for _ in range(3)]))
a = sorted(list(loc[0]), key=list(loc[0]).count)[0]
b = sorted(list(loc[1]), key=list(loc[1]).count)[0]
print(a, b)