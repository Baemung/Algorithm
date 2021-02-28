import sys
input = sys.stdin.readline

def binary_search(left, right, num):
    pivot = (left+right)//2
    if num == A[pivot] or num == A[left] or num == A[right]:
        return print(1)
    elif num > A[pivot] and pivot != left:
        return binary_search(pivot, right, num)
    elif num < A[pivot] and pivot != left:
        return binary_search(left, pivot, num)
    else:
        return print(0)

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
B = list(map(int, input().split()))
for i in B:
    binary_search(0, len(A)-1, i)