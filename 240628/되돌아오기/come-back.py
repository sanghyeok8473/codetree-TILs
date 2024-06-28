dx = [0, 1, 0, -1] # 우 하 좌 상
dy = [1, 0, -1, 0] # 우 하 좌 상

n = int(input())
order = [tuple(input().split()) for _ in range(n)]

x, y, time = 0, 0, 0
finished = False

for d, t in order:
    t = int(t)
    for i in range(1, t + 1):
        if d == 'E': # 오른쪽 이동
            x, y = x + dx[0], y + dy[0]
            time += 1
            if x == 0 and y == 0:
                finished = True
                break
        elif d == 'S': # 아래로 이동
            x, y = x + dx[1], y + dy[1]
            time += 1
            if x == 0 and y == 0:
                finished = True
                break
        elif d == 'W': # 왼쪽으로 이동
            x, y = x + dx[2], y + dy[2]
            time += 1
            if x == 0 and y == 0:
                finished = True
                break
        else: # 위로 이동
            x, y = x + dx[3], y + dy[3]
            time += 1
            if x == 0 and y == 0:
                finished = True
                break
    if finished:
        break

if finished:
    print(time)
else:
    print(-1)