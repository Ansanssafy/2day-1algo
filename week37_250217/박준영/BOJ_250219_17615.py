import sys
input = sys.stdin.readline

N = int(input())
balls = input().strip()

total_r = balls.count('R')
total_b = balls.count('B')

left_red = 0
for ball in balls:
    if ball == 'R':
        left_red += 1
    else:
        break

right_red = 0
for ball in reversed(balls):
    if ball == 'R':
        right_red += 1
    else:
        break

left_blue = 0
for ball in balls:
    if ball == 'B':
        left_blue += 1
    else:
        break

right_blue = 0
for ball in reversed(balls):
    if ball == 'B':
        right_blue += 1
    else:
        break

move_red_left = total_r - left_red
move_red_right = total_r - right_red
move_blue_left = total_b - left_blue
move_blue_right = total_b - right_blue

print(min(move_red_left, move_red_right, move_blue_left, move_blue_right))