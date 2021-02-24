def sugarDelivery():
    num = int(input())
    for i in range((num//5),-1,-1): #최대한 5를 많이 확보한 경우부터 시작
        a = 5*i
        for j in range(((num-a)//3)+1): #나머지가 3으로 나눠떨어지는지 확인
            if a+(3*j) == num:
                return i+j
    return -1
print(sugarDelivery())