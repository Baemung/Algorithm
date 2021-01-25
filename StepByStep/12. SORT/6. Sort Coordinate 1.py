li=[]
for i in range(int(input())):
    li.append([int(i) for i in input().split()])

li.sort(key=lambda x:(x[0],x[1]))

for i in range(len(li)):
    print(li[i][0],li[i][1])