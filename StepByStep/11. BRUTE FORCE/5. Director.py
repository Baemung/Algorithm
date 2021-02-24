num = int(input()) #입력 최댓값이 10000이라 브루탈포스가 가능
title = 666
while num:
    if "666" in str(title): #타이틀에 666이 들어가면 카운트
        num -= 1
    title += 1 #계속 1씩 더하기
print(title-1)