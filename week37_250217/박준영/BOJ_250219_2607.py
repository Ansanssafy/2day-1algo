import sys
from collections import Counter
input = sys.stdin.readline

N = int(input())

basic = input().strip()
basic_count = Counter(basic)
similar_count = 0

for _ in range(N-1):
    word = input().strip()
    word_count = Counter(word)
    
    diff = sum((basic_count - word_count).values())
    diff += sum((word_count - basic_count).values())
    
    if diff == 0 or diff == 1:
        similar_count += 1
    elif diff == 2 and len(basic) == len(word):
        similar_count += 1

print(similar_count)