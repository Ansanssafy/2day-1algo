def cal_per(x, y):
    return (y * 100) // x

X, Y = map(int, input().split())
percentage = cal_per(X, Y)

max_game = 1000000000
s, e = 1, max_game
result = -1

while s <= e:
    middle_game = (s+e) // 2
    new_per = cal_per(X+middle_game, Y+middle_game)
    if new_per == percentage:
        s = middle_game + 1
    else:
        e = middle_game - 1
        result = middle_game

print(result)