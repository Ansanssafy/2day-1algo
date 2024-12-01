import math
import sys
input = sys.stdin.readline

def solve_kaying_calendar(m, n, x, y):
    lcm = math.lcm(m, n)
    
    while x <= lcm:
        if (x - 1) % n + 1 == y:
            return x
        x += m
    
    return -1

t = int(input())
results = []

for _ in range(t):
    m, n, x, y = map(int, input().split())
    results.append(solve_kaying_calendar(m, n, x, y))

print("\n".join(map(str, results)))
