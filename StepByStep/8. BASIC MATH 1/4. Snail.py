a, b, v = map(int, input().split())
d = (v-b)//(a-b)
if((v-b)%(a-b) > 0):
    d += 1

print(d)