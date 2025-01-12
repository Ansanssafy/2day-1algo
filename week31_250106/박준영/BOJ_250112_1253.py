import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
arr.sort()

good_cnt = 0

for i in range(N):
    target = arr[i]
    s, e = 0, N-1
    
    while s < e:
        if s == i:
            s += 1
            continue
        if e == i:
            e -= 1
            continue
            
        sum_num = arr[s] + arr[e]
        
        if sum_num == target:
            good_cnt += 1
            break
        elif sum_num < target:
            s += 1
        else:
            e -= 1

print(good_cnt)