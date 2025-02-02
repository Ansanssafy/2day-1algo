import sys
import math

def solve():
    n = int(sys.stdin.readline().strip())

    if math.isqrt(n) ** 2 == n:
        print(1)
        return

    for i in range(1, int(math.sqrt(n)) + 1):
        if math.isqrt(n - i * i) ** 2 == (n - i * i):
            print(2)
            return

    temp = n
    while temp % 4 == 0: 
        temp //= 4
    if temp % 8 == 7:
        print(4)
        return

    print(3)

solve()
