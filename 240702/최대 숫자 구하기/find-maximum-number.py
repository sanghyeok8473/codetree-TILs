from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))

s = SortedSet()

for i in range(1, m+1):
    s.add(i)

for el in arr:
    s.remove(el)
    print(s[-1])