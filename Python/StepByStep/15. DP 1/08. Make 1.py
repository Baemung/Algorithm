n = [0]*(int(input())+1)
for i in range(2, len(n)):
    if i%3 == 0 and i%2 == 0:
        n[i] = min(n[i-1], n[i//3], n[i//2])+1
    elif i%3 == 0:
        n[i] = min(n[i-1], n[i//3])+1
    elif i%2 == 0:
        n[i] = min(n[i-1], n[i//2])+1
    else:
        n[i] = n[i-1]+1
print(n[-1])