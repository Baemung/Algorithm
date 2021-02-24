N, M = map(int, input().split())
w, b, mv = "WBWBWBWB", "BWBWBWBW", 32
chess = [input() for _ in range(N)]
for i in range(N-7): #세로 이동
    for j in range(M-7): #가로 이동
        cnt = 0
        for x in range(8): #8*8 필터
            for y in range(8):
                if x%2 == 0 and chess[i:i+8][x][j+y] != w[y]: #짝수줄은 w에 매칭
                    cnt+=1
                elif x%2 == 1 and chess[i:i+8][x][j+y] != b[y]: #홀수중은 b에 매칭
                    cnt+=1
        if min(cnt, 64-cnt) < mv: #w,b 순서 바꾼거랑 비교해서 서로 최솟값찾기
            mv = min(cnt, 64-cnt)
print(mv)