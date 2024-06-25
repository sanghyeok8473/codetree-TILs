n = int(input())
board = [0] * 101

segments = [tuple(map(int, input().split())) for _ in range(n)]

for x1, x2 in segments:
    for i in range(x1, x2 + 1):
        board[i] += 1

print(max(board))