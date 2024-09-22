import sys
I = sys.stdin.readline

N = int(I())

for i in range(N):
    num = int(I())
    
    dp = [0] * (num + 3)
    dp[1], dp[2], dp[3] = 1, 2, 4
    
    if num <=3:
        print(dp[num])
    else:
        for i in range(4, num+1):
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        
        print(dp[num])