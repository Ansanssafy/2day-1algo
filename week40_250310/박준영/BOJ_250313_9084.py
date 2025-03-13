import sys
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    N = int(input()) # 동전 개수
    arr = list(map(int, input().split())) # 동전 arr (실제 코인의 가격)
    M = int(input()) # 목표 금액
    
    dp = [0] * (M+1)
    dp[0] = 1
    for coin in arr:
        for i in range(1, M+1):
            if i >= coin:
                dp[i] += dp[i-coin]
    
    print(dp[M])
    
    