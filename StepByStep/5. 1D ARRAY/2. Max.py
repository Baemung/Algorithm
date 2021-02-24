numArr = []
max_, maxidx = 0, 0
for i in range(9):
    numArr.append(int(input()))
    if numArr[i] >= max_:
        max_ = numArr[i]
        maxidx = i+1
print(max_)
print(maxidx)