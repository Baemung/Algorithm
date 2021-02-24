a, b = int(input()), int(input())
first = a*(b%10)
second = a*((b%100)//10)
third = a*(b//100)
result = a*b
print(first, second, third, result, sep="\n")