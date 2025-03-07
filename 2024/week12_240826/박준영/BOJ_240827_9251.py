import sys

I = sys.stdin.readline

word1 = I()
word1_len = len(word1)
word2 = I()
word2_len = len(word2)
lcs = [[0] * (word1_len+1) for _ in range(word2_len+1)]

for i in range(1, word1_len):
    for j in range(1, word2_len):
        if word1[i-1] == word2[j-1]:
            lcs[j][i] = lcs[j-1][i-1] + 1
        else:
            lcs[j][i] = max(lcs[j-1][i], lcs[j][i-1])

result = 0
for n in range(word2_len+1):
    result = max(max(lcs[n]), result)

print(result)