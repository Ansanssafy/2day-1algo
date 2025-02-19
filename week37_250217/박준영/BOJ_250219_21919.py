import sys
input = sys.stdin.readline

def sieve(limit):
    is_prime = [True] * (limit + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(limit**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, limit + 1, i):
                is_prime[j] = False
    return is_prime

N = int(input())
arr = list(map(int, input().split()))

max_val = max(arr)
prime_check = sieve(max_val)

num = 1

for i in set(arr):
    if prime_check[i]:
        num *= i

if num != 1:
    print(num)
else:
    print(-1)
