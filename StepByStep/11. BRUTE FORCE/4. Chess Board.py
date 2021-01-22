n,m = map(int, input().split())
w,b,mv="WBWBWBWB","BWBWBWBW",32
chess=[]

for i in range(n):
    chess.append(input())
for i in range(n-7):
    for j in range(m-7):
        cnt = 0
        for a in range(8):
            for k in range(8):
                if(a%2 == 0 and chess[i:i+8][a][j+k] != w[k]):
                    cnt+=1
                if(a%2 == 1 and chess[i:i+8][a][j+k] != b[k]):
                    cnt+=1
        if(min(cnt, 64-cnt) < mv):
            mv = min(cnt, 64-cnt)

print(mv)