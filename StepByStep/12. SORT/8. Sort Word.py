w = sorted(list(set(input() for _ in range(int(input())))), key=lambda x:(len(x),x)) #길이, 사전순
for i in w:
    print(i)