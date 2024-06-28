dx = [0, 1, 0, -1] # 북 동 남 서
dy = [1, 0, -1, 0] # 북 동 남 서

x = 0 # 시작 x좌표
y = 0 # 시작 y좌표
d = 0 # 시작 방향(북쪽)


order = input()

for direction in range(len(order)):
    if order[direction] == 'L':
        d = (d + 3) % 4
    elif order[direction] == 'R':
        d = (d + 1) % 4
    else:
        x += dx[d]
        y += dy[d]

print(x, y)