def star(i, n, m):
    if i >= n:
        return m
    s = [j*3 for j in m]
    m = s+[j+' '*i+j for j in m]+s
    return star(i*3, n, m)

n = int(input())
m = ['***', '* *', '***']
s = star(3, n, m)
print('\n'.join(s))