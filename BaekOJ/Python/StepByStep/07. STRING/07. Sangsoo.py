a, b = input().split()
newA, newB = '', ''
for i in range(len(a)):
    newA += a[(len(a)-i-1)]
    newB += b[(len(b)-i-1)]
if int(newA) < int(newB):
    print(newB)
else:
    print(newA)