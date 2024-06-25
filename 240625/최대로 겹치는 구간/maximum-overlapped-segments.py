n = int(input())
board = [0] * 201

segments = [tuple(map(int, input().split())) for _ in range(n)]

for x1, x2 in segments:
    x1 += 100
    x2 += 100
    for i in range(x1, x2):
        board[i] += 1

print(max(board))