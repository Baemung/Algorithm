def sugarDelivery():
    num = int(input())
    for i in range((num//5),-1,-1):
        a = 5*i
        for j in range(((num-(a))//3) + 1):
            if(a+(3*j) == num):
                return i+j
    return -1

print(sugarDelivery())