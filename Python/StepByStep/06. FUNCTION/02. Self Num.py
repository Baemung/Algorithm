def non_Self(num):
    nonSelf = []
    sNum = num
    while(sNum < 10001):
        while(num > 0):
            sNum += num%10
            num //= 10
        num = sNum
        nonSelf.append(sNum)
    return nonSelf

nSelf = []
for i in range(1,10001):
    nSelf.extend(non_Self(i))

wSet = set(range(1,10001))
nSelf = set(nSelf)
self = list(wSet-nSelf)
self = sorted(self)

for i in self:
    print(i)