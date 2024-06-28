dx = [0, 1, 0, -1] # 북 동 남 서
dy = [1, 0, -1, 0] # 북 동 남 서

def inRange(a, b):
    return (0 <= a < n and 0 <= b < n)

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

cnt = 0

for i in range(n):
    for j in range(n):
        nowCnt = 0
        if inRange(i - 1, j) and board[i - 1][j] == 1:
            nowCnt += 1
        if inRange(i + 1, j) and board[i + 1][j] == 1:
            nowCnt += 1
        if inRange(i, j - 1) and board[i][j - 1] == 1:
            nowCnt += 1
        if inRange(i, j + 1) and board[i][j + 1] == 1:
            nowCnt += 1
        if nowCnt >= 3:
            cnt += 1

print(cnt)