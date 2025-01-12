import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

def solve(start, sequence):
    if len(sequence) == M:
        print(" ".join(map(str, sequence)))
        return
    
    for i in range(start, N):
        solve(i, sequence+[arr[i]])



solve(0, [])