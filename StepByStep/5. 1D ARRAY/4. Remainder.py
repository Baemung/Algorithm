inputArr = [0]*10
for i in range(len(inputArr)):
    inputArr[i] = int(input())

rem = []
for i in range(len(inputArr)):
    rem.append(inputArr[i]%42)

print(len(set(rem)))