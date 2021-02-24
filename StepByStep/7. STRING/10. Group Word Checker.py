def countGroup(word):
    if len(word) == len(set(word)): #문자가 모두 1개씩 나온 단어는 무조건 그룹 단어
        return 1
    for j in set(word):
        idx, idx_list = 0, []
        while(1):
            idx_list.append(word.find(j,idx)) #입력 단어의 문자가 단어의 어디서 나타나는지 찾고 그 인덱스를 리스트에 추가
            idx = word.find(j,idx)+1 #처음 등장한 인덱스 이후 위치를 지정
            idx = word.find(j,idx) #그 인덱스 부터 다시 문자를 찾음
            if idx == -1: #더 이상 찾을 수 없다면 break
                break
        if len(idx_list) > 1: #단어에서 동일한 문자가 여러개 나온 경우
            for m in range(len(idx_list)-1):
                if idx_list[m+1] - idx_list[m] != 1: #서로 인덱스가 연달아 존재하지 않다면(차이 2이상) 그룹 단어가 아니므로 0 반환
                    return 0
    return 1 #그룹 단어가 아닌 조건을 모두 통과했다면 1 반환

num =  int(input())
cnt = 0
for i in range(num):
    cnt += countGroup(input())
print(cnt)