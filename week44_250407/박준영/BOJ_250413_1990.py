import math

def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(math.isqrt(n)) + 1, 2):
        if n % i == 0:
            return False
    return True

def generate_palindromes(limit):
    palindromes = []
    for half in range(1, 100000):
        s = str(half)
        pal = int(s + s[-2::-1])
        if pal > limit:
            break
        palindromes.append(pal)

    for half in range(1, 100000):
        s = str(half)
        pal = int(s + s[::-1])
        if pal > limit:
            break
        palindromes.append(pal)
    return palindromes

a, b = map(int, input().split())

for num in sorted(generate_palindromes(b)):
    if a <= num <= b and is_prime(num):
        print(num)

print(-1)
