w=[]
for i in range(int(input())):
    w.append(input())

w = list(set(w))
w.sort(key=lambda x:(len(x),x))

for i in w:
    print(i)