import sys
input = sys.stdin.readline

def isOdd(num):
    if num % 2 == 1:
        return True
    return False

def solve():
    N, K = map(int, input().split())
    S = list(map(int, input().split()))
    
    s = 0
    odd_cnt = 0
    max_length = 0
    
    for e in range(N):
        if isOdd(S[e]):
            odd_cnt += 1
        
        while odd_cnt > K:
            if isOdd(S[s]):
                odd_cnt -= 1
            s += 1
        
        max_length = max(max_length, e-s+1 - odd_cnt)
    
    return max_length

if __name__ == "__main__":
    result = solve()
    
    print(result)
