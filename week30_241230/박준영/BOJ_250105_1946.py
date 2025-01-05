import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    applicants = [list(map(int, input().split())) for _ in range(N)]
    applicants.sort()
    
    cnt = 1
    min_rank = applicants[0][1]
    
    for i in range(1, N):
        if applicants[i][1] < min_rank:
            cnt += 1
            min_rank = applicants[i][1]
    
    print(cnt)
