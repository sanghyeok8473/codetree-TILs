n, m = map(int, input().split())

order = [tuple(map(int, input().split())) for _ in range(m)]
board = [[0] * n for _ in range(n)]

def inRange(r, c):
    return (0 <= r < n and 0 <= c < n)

def check(r, c):
    cnt = 0
    if inRange(r - 1, c) and board[r - 1][c] == 1:
        cnt += 1
    if inRange(r + 1, c) and board[r + 1][c] == 1:
        cnt += 1
    if inRange(r, c - 1) and board[r][c - 1] == 1:
        cnt += 1
    if inRange(r, c + 1) and board[r][c + 1] == 1:
        cnt += 1
    return True if cnt == 3 else False


for r, c in order:
    board[r - 1][c - 1] = 1
    if check(r - 1, c - 1):
        print(1)
    else:
        print(0)