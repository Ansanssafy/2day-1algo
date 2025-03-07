N, r, c = map(int, input().split())

def recur(N, r, c, result):
    if N == 0:
        if r == 1:
            result += 2
        if c == 1:
            result += 1
        print(result)
        return
    
    if r+1 > 2**(N-1) and c+1 > 2**(N-1):
        recur(N-1, r-2**(N-1), c-2**(N-1), result + (2**(N-1))**2 * 3)
    elif r+1 > 2**(N-1) and c+1 <= 2**(N-1):
        recur(N-1, r-2**(N-1), c, result + (2**(N-1))**2 * 2)
    elif r+1 <= 2**(N-1) and c+1 > 2**(N-1):
        recur(N-1, r, c-2**(N-1), result + (2**(N-1))**2)
    elif r+1 <= 2**(N-1) and c+1 <= 2**(N-1):
        recur(N-1, r, c, result)

recur(N, r, c, 0)