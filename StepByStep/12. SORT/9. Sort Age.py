p=[]
for i in range(int(input())):
    p.append([i for i in input().split()])

p.sort(key=lambda x:(int(x[0])))

for i in range(len(p)):
    print(int(p[i][0]),p[i][1])