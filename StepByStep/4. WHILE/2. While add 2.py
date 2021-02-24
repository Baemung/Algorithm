import sys
input = sys.stdin.readline

while True:
    try:
        a, b = map(int, input().split())
        if a > 0 and b < 10:
            print(a+b)
            continue
    except EOFError:
        break