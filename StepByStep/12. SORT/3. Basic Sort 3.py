import sys

A=[0]*10001

for i in range(int(sys.stdin.readline())):
    A[int(sys.stdin.readline())]+=1

for i in range(len(A)):
    if(A[i]!=0):
        for j in range(A[i]):
            print(i)