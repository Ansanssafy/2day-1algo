import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
max_length = 0
cnt_dict = dict()

s, e = 0, 0

while e < N :
    num = arr[e]
    if num not in cnt_dict:
        cnt_dict[num] = 0
    cnt_dict[num] += 1
    
    while cnt_dict[num] > K :
        cnt_dict[arr[s]] -= 1
        s += 1
    
    max_length = max(max_length, e-s+1)
    e += 1

print(max_length)