def AP_Num(n):
    total = [i for i in range(1,n+1)]
    if (len(total) < 100):
        return len(total)
    else:
        for i in range(100, n+1):
            templist = []
            num = i
            while (num > 0):
                templist.append(num%10)
                num //= 10
            for j in range(len(templist)-2):
                if(templist[j] - templist[j+1] != templist[j+1] - templist[j+2] ):
                    total.remove(i)
        return len(total)

num = int(input())
print(AP_Num(num))