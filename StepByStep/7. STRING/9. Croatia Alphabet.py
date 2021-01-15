word = input()
cword = ['c=','c-','dz=','d-','lj','nj','s=','z=']
count = len(word)

for i in cword:
    idx = 0
    while (idx < len(word)):
        if(word.find(i,idx) != -1):
            count -= 1
            idx = word.find(i,idx)+len(i)-1
        else:
            break

print(count)