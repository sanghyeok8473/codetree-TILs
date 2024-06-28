dx = [-1, 0, 1, 0] # 북 동 남 서, 인덱스 + 1은 우회전
dy = [0, 1, 0, -1] # 북 동 남 서

n, t = map(int, input().split())

order = input()

x, y, d = n // 2 , n // 2, 0 # 시작 x좌표, y좌표, 방향 설정, n은 홀수이므로 가운데의 x, y 좌표는 각각 x // 2, y // 2이고, 시작 방향은 북쪽이므로 0

board = [list(map(int, input().split())) for _ in range(n)] # 보드판 초기화

def inRange(a, b):
    return (0 <= a < n and 0 <= b < n) # 격자 내의 위치인지 체크

# 1번 나아가기 2번, 2번 나아가기 2번, 3번 나아가기 2번 .... n-1번 나아가기만 3번 하면 된다.
ans = board[x][y] # 시작 위치를 포함하므로 초기 값은 0이 아닌 시작위치의 값

for i in range(len(order)):
    if order[i] == 'L':
        d = (d + 3) % 4
    elif order[i] == 'R':
        d = (d + 1) % 4
    else:
        if inRange(x + dx[d], y + dy[d]):
            x, y = x + dx[d], y + dy[d]
            ans += board[x][y]

print(ans)