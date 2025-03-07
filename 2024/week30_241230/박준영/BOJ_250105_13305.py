import sys
input = sys.stdin.readline

N = int(input())
load = list(map(int, input().split()))
city = list(map(int, input().split()))

min_price = city[0]
cost = 0

for i in range(N-1):
    if city[i] < min_price:
        min_price = city[i]
    cost += min_price * load[i]

print(cost)