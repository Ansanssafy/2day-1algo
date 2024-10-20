import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
operator = list(map(int, input().split()))
max_num = -float("inf")
min_num = float("inf")

def get_max_min(depth, num, p, m, g, d):
    global max_num, min_num
    
    if depth == N : 
        max_num = max(max_num, num)
        min_num = min(min_num, num)
        return
    
    if p:
        get_max_min(depth+1, num+arr[depth], p-1, m, g, d)
    if m:
        get_max_min(depth+1, num-arr[depth], p, m-1, g, d)
    if g:
        get_max_min(depth+1, num*arr[depth], p, m, g-1, d)
    if d:
        get_max_min(depth+1, int(num/arr[depth]), p, m, g, d-1)

get_max_min(1, arr[0], operator[0], operator[1], operator[2], operator[3])

print(max_num)
print(min_num)