import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))

def binary_search(lst, num):
    left, right = 0, len(lst)
    while left < right:
        mid = (left + right) // 2
        if lst[mid] < num:
            left = mid + 1
        else:
            right = mid
    return left

def find_max_length(arr):
    lst = [10, 20]

    for num in arr:
        pos = binary_search(lst, num)
        
        if pos == len(lst):
            lst.append(num)
        else:
            lst[pos] = num

    return len(lst)

print(find_max_length(arr))