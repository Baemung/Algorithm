def count_Prime(p):
    n = max(p)
    num = set(range(2, n+1))
    for i in range(2, n+1):
        if i in num:
            num -= set(range(2*i, n+1, i))
    return len([x for x in p if x in list(num)])

N = int(input())
p = [int(i) for i in input().split()]
print(count_Prime(p))