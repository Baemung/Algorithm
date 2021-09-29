def binomial(n, k):
    k = min(k, n-k)
    num = den = 1
    for i in range(k):
        num = num * (n-i) % p
        den = den * (i+1) % p
    inv = pow(den, p-2, p)
    return num * inv % p


n, k, p = map(int, input().split())
print(binomial(n, k))