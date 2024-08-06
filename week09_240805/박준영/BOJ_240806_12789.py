import sys

I = sys.stdin.readline

N = int(I())

arr = list(map(int, I().split()))
stack = []
check_num = 1

for i in range(N):
    while stack and stack[-1] == check_num:
        check_num += 1
        stack.pop()
    
    if arr[i] == check_num:
        check_num += 1
    else:
        stack.append(arr[i])

while stack:
    if stack[-1] == check_num:
        check_num += 1
        stack.pop()
    else:
        print('Sad')
        break
else:
    print('Nice')
