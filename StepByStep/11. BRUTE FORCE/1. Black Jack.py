num, target = map(int, input().split())
card = [int(i) for i in input().split()]

goal = 0
for a in range(num-2):
    for b in range(a+1,num-1):
        for c in range(b+1,num):
            sum = (card[a]+card[b]+card[c])
            if(target - sum >= 0 and goal < sum):
                goal = sum

print(goal)