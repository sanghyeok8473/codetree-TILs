# 입력:
n, m, k = map(int, input().split())

alpha = [list('X' for _ in range(m + 1))] + [
    list('X' + input()) for _ in range(n)
]

q = [tuple(map(int, input().split())) for _ in range(k)]

prefix_sum = [
    [
        [0 for _ in range(3)] for _ in range(m + 1)
    ]
    for _ in range(n + 1)
]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        prefix_sum[i][j][0] = prefix_sum[i][j - 1][0] + prefix_sum[i - 1][j][0] - prefix_sum[i - 1][j - 1][0]
        prefix_sum[i][j][1] = prefix_sum[i][j - 1][1] + prefix_sum[i - 1][j][1] - prefix_sum[i - 1][j - 1][1]
        prefix_sum[i][j][2] = prefix_sum[i][j - 1][2] + prefix_sum[i - 1][j][2] - prefix_sum[i - 1][j - 1][2]

        if alpha[i][j] == 'a':
            prefix_sum[i][j][0] += 1
        elif alpha[i][j] == 'b':
            prefix_sum[i][j][1] += 1
        else:
            prefix_sum[i][j][2] += 1

for r1, c1, r2, c2 in q:
    print(prefix_sum[r2][c2][0] - prefix_sum[r1 - 1][c2][0] - prefix_sum[r2][c1 - 1][0] + prefix_sum[r1 - 1][c1 - 1][0], end = " ")
    print(prefix_sum[r2][c2][1] - prefix_sum[r1 - 1][c2][1] - prefix_sum[r2][c1 - 1][1] + prefix_sum[r1 - 1][c1 - 1][1], end = " ")
    print(prefix_sum[r2][c2][2] - prefix_sum[r1 - 1][c2][2] - prefix_sum[r2][c1 - 1][2] + prefix_sum[r1 - 1][c1 - 1][2])