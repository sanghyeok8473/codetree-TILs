from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))

s = SortedSet(range(1 , m + 1))

for el in arr:
    s.remove(el)
    print(s[-1])