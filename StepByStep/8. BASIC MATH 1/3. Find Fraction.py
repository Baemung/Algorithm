num = int(input())
cnt = 0
total = 0

while(total < num):
    cnt += 1
    total += cnt

i = cnt+num-total
j = total-num+1
if(cnt%2 == 0):
    print("%d/%d"%(i,j))
else:
    print("%d/%d"%(j,i))