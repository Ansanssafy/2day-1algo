def move_min(n, start, end, via):
    if n == 1:
        print(start, end)
        return
    
    move_min(n - 1, start, via, end)
    print(start, end)
    move_min(n - 1, via, end, start)

n = int(input())

print(2**n - 1)
move_min(n, 1, 3, 2)
