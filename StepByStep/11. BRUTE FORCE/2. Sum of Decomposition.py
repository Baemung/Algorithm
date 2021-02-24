def SoD(n):
    for i in range(1,n):
        sum_ = 0
        for j in str(i):
            sum_ += int(j)
        if sum_+i == n:
            return i
    return 0
print(SoD(int(input())))