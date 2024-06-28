n, m = map(int, input().split())

dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1] # 상 하 좌 우

order = [tuple(map(int, input().split())) for _ in range(m)]
board = [[0] * n for _ in range(n)]

def inRange(r, c):
    return (0 <= r < n and 0 <= c < n)

def check(r, c):
    cnt = 0
    for dx, dy in zip(dxs, dys):
        nx, ny = r + dx, c + dy
        if inRange(nx, ny) and board[nx][ny] == 1:
            cnt += 1
    return True if cnt == 3 else False


for r, c in order:
    board[r - 1][c - 1] = 1
    if check(r - 1, c - 1):
        print(1)
    else:
        print(0)