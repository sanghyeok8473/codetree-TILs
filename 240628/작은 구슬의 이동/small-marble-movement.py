dx = [-1, 0, 1, 0] # U R D L
dy = [0, 1, 0, -1] # U R D L

def inRange(a, b):
    return (0 <= a < n and 0 <= b < n)

n, t = map(int, input().split())
r, c, d = input().split()
r = int(r) - 1
c = int(c) - 1
d = 0 if d == 'U' else(1 if d == 'R' else (2 if d == 'D' else 3)) # dx, dy에 의한 방향 설정, 방향이 뒤집어지는 건 d = (d + 2) % 4

board = [[0] * n for _ in range(n)]

for _ in range(t):
    if inRange(r + dx[d], c + dy[d]): # 현재 방향으로 이동한다고 했을 때 격자 안이라면 이동
        r, c = r + dx[d], c + dy[d]
    else: # 현재 방향으로 이동한다고 했을 때 격자 밖이라면 방향만 바꿈(1초 소요)
        d = (d + 2) % 4

print(r + 1, c + 1) # 인덱스 때문에 1씩 뺐었으므로 다시 1을 더해서 출력