word = input()
c_word = ['c=','c-','dz=','d-','lj','nj','s=','z='] #크로아티아 알파벳을 모두 저장
count = len(word) #단어 전체길이
for i in c_word:
    idx = 0
    while idx < len(word): #크로아티아 알파벳이 마지막에 나타난다면 idx == len(word)가 됨
        if word.find(i,idx) != -1: #단어에서 크로아티아 알파벳을 찾으면
            count -= 1 #단어길이 하나 뺌
            idx = word.find(i,idx)+len(i)-1 #나타난 인덱스에서 해당 크로아티아 알파벳 길이 이후로 인덱스 변경
        else:
            break
print(count)