from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()

for _ in range(n):
    k = tuple(map(int, input().split()))
    s.add(k)

for _ in range(m):
    k = tuple(map(int, input().split()))
    idx = s.bisect_left(k)
    if idx < len(s):
        print(s[idx][0], s[idx][1])
    else:
        print(-1, -1)