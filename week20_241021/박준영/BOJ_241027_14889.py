import sys
from itertools import combinations

input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

def min_values(N, arr):
    all_people = range(N)
    min_value = float('inf')
    
    for team in combinations(all_people, N//2):
        start_team = list(team)
        link_team = list(set(all_people) - set(start_team))
        
        start_score = sum(arr[i][j] for i in start_team for j in start_team if i != j)
        link_score = sum(arr[i][j] for i in link_team for j in link_team if i != j)
        
        min_value = min(min_value, abs(start_score-link_score))        
    
    return min_value

print(min_values(N, arr))

