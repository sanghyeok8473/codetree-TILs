n = int(input())
rectangles = [tuple(map(int, input().split())) for _ in range(n)]

board =[[0] * 201 for _ in range(201)]

for i, (x1, y1, x2, y2) in enumerate(rectangles, start = 1):
    x1, y1, x2, y2 = x1 + 100, y1 + 100, x2 + 100, y2 + 100
    if i % 2 == 1: # 시작은 빨간색, 홀수는 빨간색, 여기서는 1
        for i in range(x1, x2):
            for j in range(y1, y2):
                board[i][j] = 1
    else: # 짝수는 파란색, 여기서는 2
        for i in range(x1, x2):
            for j in range(y1, y2):
                board[i][j] = 2

cnt = 0

for i in range(201):
    for j in range(201):
        if board[i][j] == 2:
            cnt += 1

print(cnt)