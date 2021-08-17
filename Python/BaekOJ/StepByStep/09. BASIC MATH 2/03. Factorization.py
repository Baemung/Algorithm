num = int(input())
for i in range(2, num+1):
    while num > 1:
        if num%i == 0:
            num //= i
            print(i)
        else:
            break