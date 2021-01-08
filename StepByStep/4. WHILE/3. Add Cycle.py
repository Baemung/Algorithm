num = int(input())
copy = num
cnt = 0

while True:
    new_num =copy%10
    copy = (copy//10 + copy%10)%10
    copy = new_num*10 + copy
    cnt += 1
    if (copy == num):
        break

print(cnt)