dx = [0, 1, 0, -1] # 우 하 좌 상
dy = [1, 0, -1, 0] # 우 하 좌 상

n, m = map(int, input().split())
x, y, d = 0, 0, 0 # 시작 x좌표, y좌표, 방향, 시작 숫자 설정

board = [[0] * m for _ in range(n)] # 보드판 초기화

def inRange(a, b):
    return (0 <= a < n and 0 <= b < m and board[a][b] == 0) # 갔던 곳을 다시 가면 안됨.

for num in range(1, n * m + 1):
    if inRange(x + dx[d], y + dy[d]): # 나아갈 곳이 격자 안이면서 이전에 간적 없는 곳이라면
        board[x][y] = num
        x, y = x + dx[d], y + dy[d]
    else: # 나아갈 곳이 격자 안이 아니거나 이미 방문해서 숫자를 기록한 곳이라면
        d = (d + 1) % 4 # 방향을 오른쪽으로 90도 틀고
        board[x][y] = num
        x, y = x + dx[d], y + dy[d]
    
for i in range(n):
    for j in range(m):
        print(board[i][j], end = " ")
    print()