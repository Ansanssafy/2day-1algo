import sys
I = sys.stdin.readline

N = int(I())
arr = list(map(int, I().split()))
money = int(I())
max_money = max(arr)


if sum(arr) <= money:
    print(max_money)
else:
    start = 0
    end = max_money
    result = 0
    
    while start <= end:
        middle = (start + end) // 2
        
        sum_money = sum(list(map(lambda x: middle-x if x < middle else 0, arr)))
        
        if middle * N - sum_money <= money:
            start = middle+1
            result = middle
        elif middle * N - sum_money > money:
            end = middle-1
    
    print(result)