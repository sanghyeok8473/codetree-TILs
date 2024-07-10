n = int(input())

ans = 1
segments = [tuple(map(int, input().split())) for _ in range(n)]

points = []

for x1, x2 in segments:
    points.append((x1, 1))
    points.append((x2, -1))

points.sort()

now = 0

for x, v in points:
    now += v
    ans = max(ans, now)

print(ans)