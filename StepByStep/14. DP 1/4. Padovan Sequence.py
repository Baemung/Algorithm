import sys
input = sys.stdin.readline

n = []
for i in range(int(input())):
    n.append(int(input()))

p = [1,1,1,2,2]+[0]*max(n)
if(max(n)>4):
    for i in range(5,max(n)+1):
        p[i] = p[i-1] + p[i-5]

for i in n:
    print(p[i-1])