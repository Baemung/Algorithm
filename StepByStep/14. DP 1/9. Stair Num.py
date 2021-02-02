num = int(input())
n = [[0 for i in range(10)] for j in range(num)]

for i in range(1,10): n[0][i] = 1

for j in range(1,num):
    for i in range(10):
        if(i != 0 and i != 9):
            n[j][i] = (n[j-1][i-1]+n[j-1][i+1])%10**9
        elif(i == 0):
            n[j][i] = (n[j-1][i+1])
        else:
            n[j][i] = (n[j-1][i-1])

sum = 0
for i in range(10): sum += n[num-1][i]

print(sum%10**9)