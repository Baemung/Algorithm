numArr = []
max = 0
maxidx = 0

for i in range(9):
    numArr.append(int(input()))
    if(numArr[i]>=max):
        max = numArr[i]
        maxidx = i+1

print(max)
print(maxidx)