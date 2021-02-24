inputArr = [int(input()) for _ in range(10)]
rem = [inputArr[i]%42 for i in range(10)]
print(len(set(rem)))