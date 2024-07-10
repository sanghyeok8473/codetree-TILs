n = int(input())

ans = 0
segments = [tuple(map(int, input().split())) for _ in range(n)]

points = []

for x1, x2 in segments:
    points.append((x1, 1))
    points.append((x2, -1))

points.sort()

now = 0

for x, v in points:
    if now == 0 and v == +1:
        ans += 1
    
    now += v

print(ans)