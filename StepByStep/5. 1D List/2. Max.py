numlist = []
max = 0
maxidx = 0

for i in range(9):
    numlist.append(int(input()))
    if(numlist[i]>=max):
        max = numlist[i]
        maxidx = i+1

print(max)
print(maxidx)