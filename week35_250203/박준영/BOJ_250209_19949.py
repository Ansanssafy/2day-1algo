import sys
input = sys.stdin.readline

arr = list(map(int, input().split()))
numbers = []
num = 0

def recur(level, cnt):
    global num
    
    if level == 10:
        if cnt >= 5:
            num += 1
        return

    for i in range(1, 6):
        if len(numbers) < 2 or (numbers[-2] != numbers[-1] or numbers[-1] != i):
            numbers.append(i)
            if arr[len(numbers) - 1] == i:
                recur(level + 1, cnt + 1)
            else:
                if 10 - (level + 1) + cnt >= 5:
                    recur(level + 1, cnt)
            numbers.pop()
            
recur(0, 0)
print(num)