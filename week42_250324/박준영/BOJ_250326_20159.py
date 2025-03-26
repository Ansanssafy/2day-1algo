import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
f_arr = [arr[0]] + [0] * (N//2-1)
e_arr = [arr[1]] + [0] * (N//2-1)

for i in range(1, N//2):
    f_arr[i] = f_arr[i-1] + arr[2*i]
    e_arr[i] = e_arr[i-1] + arr[2*i+1]

max_card = e_arr[-1]
if N != 2:
    for i in range(N//2):
        my_card = f_arr[i] + (e_arr[-1] - e_arr[i])
        another_card = f_arr[i] + (e_arr[-2] - e_arr[i-1])
        max_card = max(max_card, my_card, another_card)
else:
    max_card = max(arr)
    
print(max_card)