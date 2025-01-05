import sys
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    arr = []
    for i in range(4):
        x, y = map(int, input().split())
        arr.append((x, y))
    
    if len(set(arr)) < 4:
        print(0)
        continue
    
    lengthes = set()
    for i in range(4):
        for j in range(i, 4):
            length = (arr[i][0] - arr[j][0])**2 + (arr[i][1] - arr[j][1])**2
            lengthes.add(length)
    
    if len(lengthes) == 3:
        print(1)
    else:
        print(0)