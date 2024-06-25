rectangles = [tuple(map(int, input().split())) for _ in range(2)]
M = [tuple(map(int, input().split())) for _ in range(1)]

board =[[0] * 2001 for _ in range(2001)]


for x1, y1, x2, y2 in rectangles:
    x1 += 1000
    y1 += 1000
    x2 += 1000
    y2 += 1000
    for x in range(x1, x2):
        for y in range(y1, y2):
            board[x][y] = 1

for x1, y1, x2, y2 in M:
    x1 += 1000
    y1 += 1000
    x2 += 1000
    y2 += 1000
    for x in range(x1, x2):
        for y in range(y1, y2):
            board[x][y] = 0

cnt = 0

for x in range(2001):
    for y in range(2001):
        cnt += board[x][y]
print(cnt)