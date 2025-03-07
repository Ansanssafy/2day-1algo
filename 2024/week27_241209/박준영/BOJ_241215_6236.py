def money_income(money, n, m, k):
    cur_sum = 0
    cnt = 1

    for value in money:
        if cur_sum + value > k:
            cnt += 1
            cur_sum = value
            if cnt > m:
                return False
        else:
            cur_sum += value

    return True

def binary(n, m, money):
    start = max(money)
    end = sum(money)
    result = end

    while start <= end:
        mid = (start + end) // 2

        if money_income(money, n, m, mid):
            result = mid
            end = mid - 1
        else:
            start = mid + 1

    return result

n, m = map(int, input().split())
money = [int(input()) for _ in range(n)]

print(binary(n, m, money))
