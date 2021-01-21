n=int(input())
m=['***','* *','***']
i=3

while(i<n):
    s=[j*3 for j in m]
    m=s+[j+' '*i+j for j in m]+s
    i*=3

print('\n'.join(m))