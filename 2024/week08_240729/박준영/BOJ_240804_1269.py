import sys

I = sys.stdin.readline

N, M = map(int, I().split())

A = set(map(int, I().split()))
B = set(map(int, I().split()))

print(len((A|B) - (A&B)))