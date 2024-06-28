dx = [-1, 0, 1, 0] # 북 동 남 서
dy = [0, 1, 0, -1] # 북 동 남 서

order = input()

x, y, d, time, ans = 0, 0, 0, 0, -1
finished = False

def move():
    global x, y, d, time, ans
    x, y = x + dx[d], y + dy[d]
    time += 1
    if x == 0 and y == 0:
        ans = time
        return True
        
    return False

for i in range(len(order)):
    if order[i] == 'L':
        d = (d + 3) % 4
        time += 1
    elif order[i] == 'R':
        d = (d + 1) % 4
        time += 1
    else:
        finished = move()
    if finished:
        break

print(ans)