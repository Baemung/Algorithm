li=[]
for i in range(int(input())):
    li.append(int(input()))
li=(list(set(li)))

for i in range(len(li)-1):
    for j in range(i,len(li)):
        if(li[i]>li[j]):
            temp = li[i]
            li[i] = li[j]
            li[j] = temp

for i in li:
    print(i)