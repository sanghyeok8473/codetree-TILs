dy = [1, -1, 0, 0] # 북 남 서 동
dx = [0, 0, -1, 1] # 북 남 서 동

x = 0 # 시작 x좌표
y = 0 # 시작 y좌표

n = int(input())
direction = [tuple(input().split()) for _ in range(n)]

for d, t in direction:
    t = int(t)
    if d == 'W':
        x += dx[2] * t
        y += dy[2] * t
    elif d == 'S':
        x += dx[1] * t
        y += dy[1] * t
    elif d == 'N':
        x += dx[0] * t
        y += dy[0] * t
    else:
        x += dx[3] * t
        y += dy[3] * t

print(x, y)