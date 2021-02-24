a, b, c = map(int, input().split())
test1A = (a+b)%c
test1B = ((a%c)+(b%c))%c
test2A = (a*b)%c
test2B = ((a%c)*(b%c))%c
print(test1A, test1B, test2A, test2B, sep="\n")