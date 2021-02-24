inputArr = [int(input()) for _ in range(3)]
num = 1
for i in range(3):
    num *= inputArr[i]
count_list = [0]*10
while num > 0:
    comp_num = num%10
    for i in range(10):
        if i == comp_num:
            count_list[i] += 1
    num //= 10
for i in range(10):
    print(count_list[i])