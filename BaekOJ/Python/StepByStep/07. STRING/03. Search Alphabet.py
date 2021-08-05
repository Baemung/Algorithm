text = input()
alphabets = 'abcdefghijklmnopqrstuvwxyz'
idx = ['-1']*len(alphabets)
for i in range(len(alphabets)):
    for j in range(len(text)):
        if alphabets[i] == text[j]:
            idx[i] = str(j)
            break
print(' '.join(idx))