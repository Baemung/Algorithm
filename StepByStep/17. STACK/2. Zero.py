import sys
input = sys.stdin.readline

def STACK(n):
    if(n==0):li.pop()
    else:li.append(n)

li=[]
for i in range(int(input())):
    STACK(int(input()))
print(sum(li))