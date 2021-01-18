def searchP(p):
    n = max(p)
    num = set(range(2, n + 1))
    for i in range(2, n + 1):
        if i in num:
            num -= set(range(2 * i, n + 1, i))
    prime = [x for x in p if x in list(num)]
    return len(prime)

x = int(input())
p = [int(i) for i in input().split()]
print(searchP(p))