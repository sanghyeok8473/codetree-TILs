from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))
s = SortedSet()
for el in arr:
    s.add(el)

for _ in range(m):
    k = int(input())
    idx = s.bisect_left(k)
    if idx < n:
        print(s[idx])
    else:
        print(-1)