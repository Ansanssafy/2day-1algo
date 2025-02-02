import sys
input = sys.stdin.readline

t = int(input().strip())

for tc in range(t):
    n = int(input().strip())
    clothes = {}
    
    for i in range(n):
        a, category = input().strip().split()
        if category in clothes:
            clothes[category] += 1
        else:
            clothes[category] = 1

    result = 1
    for count in clothes.values():
        result *= (count + 1)

    print(result - 1)