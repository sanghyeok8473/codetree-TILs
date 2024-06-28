dx = [0, -1, 0, 1] # 우 상 좌 하
dy = [1, 0, -1, 0] # 우 상 좌 하

n = int(input())

x, y, d = n // 2 , n // 2, 0 # 시작 x좌표, y좌표, 방향 설정

board = [[0] * n for _ in range(n)] # 보드판 초기화
board[x][y] = 1

num = 2

def inRange(a, b):
    return (0 <= a < n and 0 <= b < m and board[a][b] == 0) # 갔던 곳을 다시 가면 안됨.

# 1번 나아가기 2번, 2번 나아가기 2번, 3번 나아가기 2번 .... n-1번 나아가기만 3번 하면 된다.

for count in range(1, n - 1): # n - 2번 까지는 2번씩 나아가고, 나아갈 횟수를 증가시킨다.
    for _ in range(2):
        for _ in range(count):
            x, y = x + dx[d], y + dy[d]
            board[x][y] = num
            num += 1
        d = (d + 1) % 4

for _ in range(3): # n - 1번 나아가기는 3번 해야함.
    for _ in range(n - 1):
        x, y = x + dx[d], y + dy[d]
        board[x][y] = num
        num += 1
    d = (d + 1) % 4

    
for i in range(n):
    for j in range(n):
        print(board[i][j], end = " ")
    print()