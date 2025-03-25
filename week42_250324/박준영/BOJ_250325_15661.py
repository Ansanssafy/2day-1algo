import sys
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

def cal_score(team):
    score = 0
    for x in range(len(team)):
        for y in range(x+1, len(team)):
            a, b = team[x], team[y]
            score += arr[a][b] + arr[b][a]
    return score

min_score = float('inf')
for i in range(1, (1<<N)-1):
    s_team = []
    l_team = []
    for j in range(N):
        if i & (1<<j):
            s_team.append(j)
        else:
            l_team.append(j)
    
    s_score = cal_score(s_team)
    l_score = cal_score(l_team)
    
    diff = abs(s_score-l_score)
    min_score = min(diff, min_score)
    
    if diff == 0:
        break

print(min_score)