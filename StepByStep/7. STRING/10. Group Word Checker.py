def countGroup(word):
    for j in set(word):
        if (len(word) == len(set(word))):
            return 1

        idx = 0
        idxlist = []
        while(1):
            idxlist.append(word.find(j,idx))
            idx = word.find(j,idx)+1
            idx = word.find(j,idx)
            if(idx == -1):
                break
        if(len(idxlist) > 1):
            for m in range(len(idxlist)-1):
                if(idxlist[m+1] - idxlist[m] != 1):
                    return 0
    return 1

num =  int(input())
cnt = 0

for i in range(num):
    word = input()
    cnt += countGroup(word)

print(cnt)