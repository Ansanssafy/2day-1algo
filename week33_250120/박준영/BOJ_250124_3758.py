import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n, k, t, m = map(int, input().split())
    scores = [[0] * k for _ in range(n)]
    submit_count = [0] * n
    last_submission = [0] * n

    for time in range(1, m + 1):
        team, problem, score = map(int, input().split())
        team -= 1
        problem -= 1

        scores[team][problem] = max(scores[team][problem], score)

        submit_count[team] += 1
        last_submission[team] = time

    total_scores = [sum(scores[team]) for team in range(n)]

    ranking = sorted(range(n), key=lambda team: (-total_scores[team], submit_count[team], last_submission[team]))

    print(ranking.index(t - 1) + 1)
