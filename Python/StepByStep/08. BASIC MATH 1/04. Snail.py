a, b, v = map(int, input().split())
d = (v-b)//(a-b) #마지막날 딱 맞춰 올라갔을 때
if (v-b)%(a-b) > 0: #딱 맞춰서 못올라갔을 때
    d += 1
print(d)