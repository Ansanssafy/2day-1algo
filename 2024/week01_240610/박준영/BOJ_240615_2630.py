def check_papar(N, a, b):
    default_paper = arr[a][b]
    
    for i in range(a, a+N):
        for j in range(b, b+N):
            if arr[i][j] != default_paper:
                return False
    return True

def recur(N, a, b):
    global white, blue
    # check paper
    if check_papar(N, a, b):
        if arr[a][b]:
            blue += 1
        else:
            white += 1
        return
    
    recur(N//2, a+N//2, b+N//2)
    recur(N//2, a, b+N//2)
    recur(N//2, a+N//2, b)
    recur(N//2, a, b)


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

white = 0
blue = 0

recur(N, 0, 0)

print(white)
print(blue)
