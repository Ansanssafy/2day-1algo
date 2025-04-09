import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = set(map(int, input().split()))

INF = float('inf')
dp = [[INF] * (106) for _ in range(N+6)]
dp[0][0] = 0

for day in range(N+1):
    for coupon in range(40):
        if dp[day][coupon] == INF:
            continue
        
        value = dp[day][coupon]
        
        if day+1 in arr:
            dp[day+1][coupon] = min(value, dp[day+1][coupon])
        if coupon>=3:
            dp[day+1][coupon-3] = min(value, dp[day+1][coupon-3])
        
        dp[day+1][coupon] = min(dp[day+1][coupon], value+10000)
        
        for k in range(1, 4):
            dp[day+k][coupon+1] = min(dp[day+k][coupon+1], value+25000)
        
        for m in range(1, 6):
            dp[day+m][coupon+2] = min(dp[day+m][coupon+2], value+37000)

print(min(dp[N]))
            