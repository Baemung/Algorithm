import sys
input = sys.stdin.readline

N = int(input())
T = sorted([list(map(int, input().split())) for _ in range(N)], key=lambda x:(x[0], x[1]))
room = [T[0]]
for i in range(1, N):
    if room[-1][1] > T[i][0]:
        if room[-1][1] >= T[i][1]:
            room[-1] = T[i]
    else:
        room.append(T[i])
print(len(room))