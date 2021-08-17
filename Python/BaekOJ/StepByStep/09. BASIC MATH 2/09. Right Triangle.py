def is_RightT(li):
    li = sorted(li)
    if li[0]**2+li[1]**2 == li[2]**2:
        return "right"
    else:
        return "wrong"

while True:
    num = [int(i) for i in input().split()]
    if sum(num) == 0:
        break
    print(is_RightT(num))