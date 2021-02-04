import sys
input = sys.stdin.readline

def fac(n):
    f,k,cnt = 1,0,0
    while(n): f,n = f*n, n-1
    while(k == 0):
        k,f = f%10,f//10
        if(k == 0): cnt+=1
    return cnt
print(fac(int(input())))