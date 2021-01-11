a = int(input())
b = int(input())
c = int(input())

count_list = [0]*10

num = a*b*c
while(num>0):
    comp_num = num%10
    for i in range(10):
        if(i == comp_num):
            count_list[i] += 1
    num //= 10

for i in range(10): print(count_list[i])