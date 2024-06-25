n = int(input())
rectangles = [tuple(map(int, input().split())) for _ in range(n)]

board =[[0] * 201 for _ in range(201)]


for x1, y1 in rectangles:
    x1, y1 = x1 + 100, y1 + 100
    for x in range(x1, x1 + 8):
        for y in range(y1, y1 + 8):
            board[x][y] = 1

cnt = 0

for x in range(201):
    for y in range(201):
        cnt += board[x][y]
print(cnt)