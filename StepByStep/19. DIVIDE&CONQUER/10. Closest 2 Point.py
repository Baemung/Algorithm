import sys
input = sys.stdin.readline

def get_dist(pt1, pt2):
    return (pt1[0] - pt2[0])**2 + (pt1[1] - pt2[1])**2

def closest_Pair(left, right):
    if left == right:
        return sys.maxsize
    elif right - left == 1:
        return get_dist(pts[left], pts[right])

    mid = (left+right)//2
    left_side = closest_Pair(left, mid)
    right_side = closest_Pair(mid, right)
    min_ = min(left_side, right_side)

    mid_li = []
    for i in range(left, right+1):
        if (pts[mid][0] - pts[i][0])**2 < min_:
            mid_li.append(pts[i])
    mid_li.sort(key=lambda x: x[1])

    for i in range(len(mid_li) - 1):
        for j in range(i+1, len(mid_li)):
            if (mid_li[i][1] - mid_li[j][1])**2 < min_:
                min_ = min(min_, get_dist(mid_li[i], mid_li[j]))
            else:
                break
    return min_

n = int(input())
pts = sorted([list(map(int, input().split())) for _ in range(n)], key= lambda x:x[0])
print(closest_Pair(0, len(pts)-1))