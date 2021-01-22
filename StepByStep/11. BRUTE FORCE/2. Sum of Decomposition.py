def SoD(n):
    for i in range(1,n):
        sum = 0
        for j in str(i):
            sum += int(j)
        if(sum+i == n):
            return i
    return 0

num = int(input())
print(SoD(num))