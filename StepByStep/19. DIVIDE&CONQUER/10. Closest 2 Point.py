import sys
input = sys.stdin.readline

def get_distance(pt1, pt2):
    return (pt1[0]-pt2[0])**2+(pt1[1]-pt2[1])**2

def closest_Pair(left, right):
    if left == right: #점 1개만 존재
        return sys.maxsize
    elif right - left == 1: #점이 2개만 존재
        return get_distance(pts[left], pts[right])
    mid = (left+right)//2 #좌우분할
    left_side = closest_Pair(left, mid) #왼쪽
    right_side = closest_Pair(mid, right) #오른쪽
    min_ = min(left_side, right_side) #좌우중 최단거리(아직 중간부분은 계산X사애)
    mid_li = [] #중간점들의 리스트
    for i in range(left, right+1): #O(n)
        if (pts[mid][0]-pts[i][0])**2 < min_: #x축 기준으로 중앙과의 거리가 min보다 작은점만 중간점으로 고려
            mid_li.append(pts[i])
    mid_li.sort(key=lambda x: x[1]) #선택된 중간점들을 y축으로 정렬
    for i in range(len(mid_li)-1):
        for j in range(i+1, len(mid_li)):
            if (mid_li[i][1]-mid_li[j][1])**2 < min_: #y축을 기준으로 거리가 min보다 작은점만 고려하려 계산
                min_ = min(min_, get_distance(mid_li[i], mid_li[j]))
            else: #y축을 기준으로 거리가 min보다 크다면 고려X
                break
    return min_

n = int(input())
pts = sorted([list(map(int, input().split())) for _ in range(n)], key= lambda x:x[0]) #우선 x축으로 정렬
print(closest_Pair(0, len(pts)-1))