hour, min = map(int, input().split())
if min-45 < 0:
    setH = hour-1
    setM = min+15
    if setH < 0:
        setH += 24
else:
    setH = hour
    setM = min-45
print(setH, setM)