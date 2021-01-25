import sys
import statistics as s

num = []
for i in range(int(sys.stdin.readline())):
    num.append(int(sys.stdin.readline()))
num.sort()

cnt = s.multimode(num)
if(len(cnt)>=2):
    a=cnt[1]
else:
    a=cnt[0]

print(round(s.mean(num)),s.median(num),a,num[-1]-num[0],sep='\n')