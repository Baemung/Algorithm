import sys
input = sys.stdin.readline

n = int(input())
t = sorted([list(map(int, input().split())) for _ in range(n)],key=lambda x:(x[0],x[1]))
room = [t[0]]
for i in range(1,n):
    if(room[-1][1] > t[i][0]):
        if(room[-1][1] >= t[i][1]):
            room[-1] = t[i]
    else:
        room.append(t[i])
print(len(room))