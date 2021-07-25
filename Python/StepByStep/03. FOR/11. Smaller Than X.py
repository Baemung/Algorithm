n, x = map(int, input().split())
num = [int(i) for i in input().split()]
smaller_x=[]
for i in range(n):
    if num[i] < x:
        smaller_x.append(str(num[i]))
print(' '.join(smaller_x))