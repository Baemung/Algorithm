num = int(input())
cnt, comp = 1, 1
while comp < num:
    comp += cnt*6
    cnt += 1
print(cnt)