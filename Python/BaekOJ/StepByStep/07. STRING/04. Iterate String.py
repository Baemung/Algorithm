testCase = int(input())
for i in range(testCase):
    a, b = input().split()
    new_b = ''
    for j in b:
        new_b += j*int(a)
    print(new_b)