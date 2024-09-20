import sys
I = sys.stdin.readline

arr = I()

# +만 있다면 간단히 처리
check = arr.split('-')
if len(check) == 1:
    print(sum(map(int, arr.split('+'))))

# +만 있는게 아니라면?
else:
    num = None
    start = 0
    end = 0
    for i in range(len(arr)):
        if arr[i] == '-':
            end = i
            if num == None:
                num = sum(map(int, arr[start:end].split('+')))
            else:
                num -= sum(map(int, arr[start:end].split('+')))
            
            start = i+1
    num -= sum(map(int, arr[start:len(arr)].split('+')))

    print(num)