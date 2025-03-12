import sys
input = sys.stdin.readline

def is_vaild(board, r, c):
    if r >= 1 and c >= 1:
        if board[r][c] and board[r-1][c] and board[r][c-1] and board[r-1][c-1]:
            return False
    return True

def backtrack(board, r, c, n, m):
    if c == m:
        r += 1
        c = 0
    if r == n:
        return 1
    
    count = backtrack(board, r, c+1, n, m)
    
    board[r][c] = 1
    if is_vaild(board, r, c):
        count += backtrack(board, r, c+1, n, m)
    board[r][c] = 0
    
    return count



N, M = map(int, input().split())
board = [[0]*M for _ in range(N)]

result = backtrack(board, 0, 0, N, M)

print(result)
