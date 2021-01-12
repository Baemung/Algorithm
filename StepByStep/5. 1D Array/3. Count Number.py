inputArr = [0]*3
for i in range(len(inputArr)):
    inputArr[i] = int(input())

num = 1
for i in range(len(inputArr)):
    num *= inputArr[i]

count_list = [0]*10
while(num>0):
    comp_num = num%10
    for i in range(10):
        if(i == comp_num):
            count_list[i] += 1
    num //= 10

for i in range(10): print(count_list[i])